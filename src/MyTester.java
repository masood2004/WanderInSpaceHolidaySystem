public class MyTester {
    public static void main(String[] args) {
        MyTester tester = new MyTester();
        tester.doTest();
    }

    /**
     * Performs a series of tests on the Resort system to ensure that methods in the WISH interface work as expected.
     */
    public void doTest() {
        // Create a Resort object but reference it with WISH interface (polymorphism)
        WISH resort = new Resort();

        // Test adding a card
        System.out.println("Testing addCard() method:");
        resort.addCard(new Card(1003, "Sam", 10, 20));
        resort.displayWorldDetails();  // Check the output after adding the new card

        // Test displaying world details
        System.out.println("\nTesting displayWorldDetails() method:");
        resort.displayWorldDetails();

        // Test checking journey feasibility
        System.out.println("\nTesting checkJourneyFeasibility() method:");
        Card card = new Card(1000, "Lynn", 7, 10);
        World destination = new World(2, "Winter Wonderland", 6, 2);
        boolean canTravel = resort.checkJourneyFeasibility(card, destination);
        System.out.println("Can card travel to destination world? " + canTravel);

        // Test shuttle journey
        System.out.println("\nTesting executeShuttleJourney() method:");
        Shuttle shuttle = new Shuttle("S101", new World(1, "Tropical Paradise", 7, 2), new World(2, "Winter Wonderland", 6, 2));
        resort.executeShuttleJourney(card, shuttle);

        // Test converting points to bitcoins
        System.out.println("\nTesting convertPointsToBitcoins() method:");
        resort.convertPointsToBitcoins();  // Check if all worlds converted points to bitcoins

        // Test showing card details
        System.out.println("\nTesting showCardDetails() method:");
        resort.showCardDetails(1000);
    }
}
