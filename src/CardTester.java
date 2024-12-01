public class CardTester {

    /**
     * Main method to test the functionality of the Card class.
     * This method creates Card objects, tests various functionalities like adding/deducting bitcoins,
     * converting points to bitcoins, and updating the card after a journey.
     * It also prints the card details before and after operations to verify the results.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create some Card objects for testing
        Card card1 = new Card(1000, "Lynn", 5, 10);  // Card 1 with ID 1000, name "Lynn", luxury rating 5, 10 bitcoins
        Card card2 = new Card(1001, "May", 3, 20);   // Card 2 with ID 1001, name "May", luxury rating 3, 20 bitcoins

        // Display initial details of the cards
        System.out.println(card1);  // Print the details of card 1
        System.out.println(card2);  // Print the details of card 2

        // Test adding and deducting bitcoins
        card1.addBitcoins(5);       // Add 5 bitcoins to card 1
        card2.deductBitcoins(10);   // Deduct 10 bitcoins from card 2 (successful since card 2 has 20 bitcoins)

        // Test converting points to bitcoins
        card1.convertPointsToBitcoins();  // Convert points to bitcoins for card 1 (if applicable)

        // Test updating card after journey
        card1.updateAfterJourney();  // Update card 1 after a shuttle journey (deduct 4 bitcoins and add 1 point)

        // Display updated details of the cards to check the changes
        System.out.println(card1);  // Print the updated details of card 1
        System.out.println(card2);  // Print the updated details of card 2
    }
}
