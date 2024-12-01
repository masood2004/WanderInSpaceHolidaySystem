import java.util.Scanner;

public class ResortUI {
    private Scanner scanner;
    private World world1, world2, world3;
    private Card card1, card2, card3;
    private Shuttle shuttle1, shuttle2, shuttle3;

    /**
     * Constructor for the ResortUI class. Initializes the scanner for user input, creates worlds,
     * creates cards, adds cards to worlds, and creates shuttle connections.
     */
    public ResortUI() {
        scanner = new Scanner(System.in);

        // Create Worlds
        world1 = new World(1, "Tropical Paradise", 7, 2);
        world2 = new World(2, "Winter Wonderland", 6, 2);
        world3 = new World(3, "Moonlit Forest", 8, 3);

        // Create Cards
        card1 = new Card(1000, "Lynn", 7, 10);
        card2 = new Card(1001, "May", 5, 15);
        card3 = new Card(1002, "Jake", 8, 12);

        // Add cards to worlds
        world1.arrive(card1);
        world2.arrive(card2);
        world3.arrive(card3);

        // Create Shuttle connections
        shuttle1 = new Shuttle("S101", world1, world2);
        shuttle2 = new Shuttle("S102", world2, world3);
        shuttle3 = new Shuttle("S103", world1, world3);
    }

    /**
     * Displays the main menu options for the user to interact with the system.
     * Loops until the user chooses to exit (option 6).
     */
    public void displayMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n----- Resort World Management System -----");
            System.out.println("1. Display World Details");
            System.out.println("2. Check Journey Feasibility");
            System.out.println("3. Execute Shuttle Journey");
            System.out.println("4. Convert Points to Bitcoins");
            System.out.println("5. Show Card Details");
            System.out.println("6. Exit");
            System.out.print("Please choose an option (1-6): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayWorldDetails();
                    break;

                case 2:
                    checkJourneyFeasibility();
                    break;

                case 3:
                    executeShuttleJourney();
                    break;

                case 4:
                    convertPointsToBitcoins();
                    break;

                case 5:
                    showCardDetails();
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting Resort World Management System...");
                    break;

                default:
                    System.out.println("Invalid option, please choose a number between 1-6.");
            }
        }
    }

    /**
     * Displays details of all worlds including their name, luxury rating, and the cards in each world.
     */
    private void displayWorldDetails() {
        System.out.println(world1);
        System.out.println(world2);
        System.out.println(world3);
    }

    /**
     * Allows the user to check if a specific card can travel to a destination world.
     * It takes card ID and destination world number as input.
     */
    private void checkJourneyFeasibility() {
        System.out.print("Enter Card ID to check journey feasibility: ");
        int cardId = scanner.nextInt();
        System.out.print("Enter Destination World Number: ");
        int destWorldNum = scanner.nextInt();

        Card card = findCardById(cardId);
        if (card == null) {
            System.out.println("Card not found.");
            return;
        }

        World destinationWorld = getWorldByNumber(destWorldNum);
        if (destinationWorld == null) {
            System.out.println("Destination world not found.");
            return;
        }

        // Check if the card can travel to the destination world
        if (shuttle1.canTravel(card) && shuttle1.destinationWorld.equals(destinationWorld)) {
            System.out.println("Card can travel to " + destinationWorld.getName());
        } else {
            System.out.println("Card cannot travel to " + destinationWorld.getName());
        }
    }

    /**
     * Executes a shuttle journey for a specific card.
     * It takes card ID and shuttle journey code as input to perform the journey.
     */
    private void executeShuttleJourney() {
        System.out.print("Enter Card ID for shuttle journey: ");
        int cardId = scanner.nextInt();
        System.out.print("Enter Shuttle Journey Code (S101/S102/S103): ");
        String journeyCode = scanner.next();

        Card card = findCardById(cardId);
        if (card == null) {
            System.out.println("Card not found.");
            return;
        }

        Shuttle shuttleToUse = null;
        // Choose shuttle based on journey code
        if (journeyCode.equals("S101")) {
            shuttleToUse = shuttle1;
        } else if (journeyCode.equals("S102")) {
            shuttleToUse = shuttle2;
        } else if (journeyCode.equals("S103")) {
            shuttleToUse = shuttle3;
        }

        if (shuttleToUse != null) {
            System.out.println(shuttleToUse.processJourney(card));
        } else {
            System.out.println("Invalid Shuttle Journey Code.");
        }
    }

    /**
     * Converts points to bitcoins for all cards in each world.
     * This method is called when the user selects option 4 from the menu.
     */
    private void convertPointsToBitcoins() {
        world1.convertAllPointsToBitcoins();
        world2.convertAllPointsToBitcoins();
        world3.convertAllPointsToBitcoins();
        System.out.println("Points converted to bitcoins for all cards in each world.");
    }

    /**
     * Displays the details of a specific card based on the card ID.
     * If the card is found, its details are printed; otherwise, an error message is displayed.
     */
    private void showCardDetails() {
        System.out.print("Enter Card ID to show details: ");
        int cardId = scanner.nextInt();
        Card card = findCardById(cardId);
        if (card != null) {
            System.out.println(card);
        } else {
            System.out.println("Card not found.");
        }
    }

    /**
     * Finds a card by its ID.
     *
     * @param cardId The ID of the card to search for.
     * @return The card object if found, otherwise null.
     */
    private Card findCardById(int cardId) {
        if (cardId == card1.getCardId()) return card1;
        if (cardId == card2.getCardId()) return card2;
        if (cardId == card3.getCardId()) return card3;
        return null;
    }

    /**
     * Returns the world corresponding to the provided world number.
     *
     * @param worldNumber The world number to search for.
     * @return The world object if found, otherwise null.
     */
    private World getWorldByNumber(int worldNumber) {
        switch (worldNumber) {
            case 1: return world1;
            case 2: return world2;
            case 3: return world3;
            default: return null;
        }
    }
}
