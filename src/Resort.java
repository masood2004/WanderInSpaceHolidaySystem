public class Resort implements WISH {
    private World world1, world2, world3;
    private Card card1, card2, card3;
    private Shuttle shuttle1, shuttle2, shuttle3;

    /**
     * Constructor for the Resort class. Initializes worlds, cards, and shuttle connections.
     */
    public Resort() {
        world1 = new World(1, "Tropical Paradise", 7, 2);
        world2 = new World(2, "Winter Wonderland", 6, 2);
        world3 = new World(3, "Moonlit Forest", 8, 3);
        card1 = new Card(1000, "Lynn", 7, 10);
        card2 = new Card(1001, "May", 5, 15);
        card3 = new Card(1002, "Jake", 8, 12);
        world1.arrive(card1);
        world2.arrive(card2);
        world3.arrive(card3);
        shuttle1 = new Shuttle("S101", world1, world2);
        shuttle2 = new Shuttle("S102", world2, world3);
        shuttle3 = new Shuttle("S103", world1, world3);
    }

    /**
     * Adds a card to a specific world based on its card ID.
     * This is a simple example of how cards can be added to worlds.
     *
     * @param card The Card object to be added.
     */
    @Override
    public void addCard(Card card) {
        // Example of adding a card to a world (you may choose the world based on card data)
        if (card.getCardId() == 1000) world1.arrive(card);
        else if (card.getCardId() == 1001) world2.arrive(card);
        else if (card.getCardId() == 1002) world3.arrive(card);
    }

    /**
     * Displays the details of all worlds, including their name, luxury rating, and available space.
     */
    @Override
    public void displayWorldDetails() {
        System.out.println(world1);
        System.out.println(world2);
        System.out.println(world3);
    }

    /**
     * Checks if a card can travel to a destination world.
     *
     * @param card The Card object to be checked.
     * @param destination The World object representing the destination world.
     * @return True if the card can travel to the destination world, otherwise false.
     */
    @Override
    public boolean checkJourneyFeasibility(Card card, World destination) {
        // Check if the card can travel to the destination world
        return shuttle1.canTravel(card) && shuttle1.destinationWorld.equals(destination);
    }

    /**
     * Inner class that holds the result of a shuttle journey.
     * It contains the success status and an optional message.
     */
    public class JourneyStatus {
        private boolean success;
        private String message;

        public JourneyStatus(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * Executes a shuttle journey for a given card and shuttle.
     *
     * @param card The Card object that is traveling.
     * @param shuttle The Shuttle object representing the shuttle journey.
     * @return JourneyStatus object indicating whether the journey was successful or not.
     */
    @Override
    public JourneyStatus executeShuttleJourney(Card card, Shuttle shuttle) {
        // Execute the shuttle journey
        if (shuttle.canTravel(card)) {
            return new JourneyStatus(true, shuttle.processJourney(card));
        } else {
            return new JourneyStatus(false, "Card cannot travel with this shuttle.");
        }
    }

    /**
     * Converts all points to bitcoins for all cards in all worlds.
     * This method is used to convert points earned by cards into bitcoins.
     */
    @Override
    public void convertPointsToBitcoins() {
        world1.convertAllPointsToBitcoins();
        world2.convertAllPointsToBitcoins();
        world3.convertAllPointsToBitcoins();
    }

    /**
     * Inner class that holds the result of showing card details.
     * It contains the success status and an optional message.
     */
    public class CardDetailsResult {
        private boolean success;
        private String message;

        public CardDetailsResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * Shows the details of a specific card identified by its card ID.
     *
     * @param cardId The ID of the card to display details for.
     * @return CardDetailsResult object indicating whether the card was found or not and the message.
     */
    @Override
    public CardDetailsResult showCardDetails(int cardId) {
        Card card = null;

        if (cardId == card1.getCardId()) card = card1;
        else if (cardId == card2.getCardId()) card = card2;
        else if (cardId == card3.getCardId()) card = card3;

        if (card != null) {
            return new CardDetailsResult(true, card.toString());
        } else {
            return new CardDetailsResult(false, "Card not found.");
        }
    }
}
