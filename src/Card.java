public class Card {

    // Instance variables
    private int cardId;        // The unique identifier for this card
    private String name;       // The name of the cardholder
    private int luxuryRating;  // The luxury rating of the card
    private int bitcoins;      // The number of bitcoins the card currently has
    private int points;        // The number of points the card currently has

    /**
     * Constructor to initialize the card object with specific values.
     *
     * @param cardId        The unique identifier for the card
     * @param name          The name of the cardholder
     * @param luxuryRating  The luxury rating of the card
     * @param bitcoins      The initial number of bitcoins on the card
     */
    public Card(int cardId, String name, int luxuryRating, int bitcoins) {
        this.cardId = cardId;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.bitcoins = bitcoins;
        this.points = 0;  // Default points are set to 0
    }

    // Accessor methods (getter methods)

    /**
     * Accessor method to get the unique ID of the card.
     *
     * @return The card's unique ID
     */
    public int getCardId() {
        return cardId;
    }

    /**
     * Accessor method to get the name of the cardholder.
     *
     * @return The cardholder's name
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method to get the luxury rating of the card.
     *
     * @return The card's luxury rating
     */
    public int getLuxuryRating() {
        return luxuryRating;
    }

    /**
     * Accessor method to get the number of bitcoins on the card.
     *
     * @return The current number of bitcoins
     */
    public int getBitcoins() {
        return bitcoins;
    }

    /**
     * Accessor method to get the number of points on the card.
     *
     * @return The current number of points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Method to add a specified number of bitcoins to the card.
     *
     * @param amount The number of bitcoins to be added
     */
    public void addBitcoins(int amount) {
        this.bitcoins += amount;
    }

    /**
     * Method to deduct a specified number of bitcoins from the card.
     *
     * @param amount The number of bitcoins to be deducted
     * @return true if the deduction was successful (enough bitcoins), false otherwise
     */
    public boolean deductBitcoins(int amount) {
        if (amount <= bitcoins) {
            this.bitcoins -= amount;
            return true;  // Successful deduction
        } else {
            return false;  // Insufficient bitcoins
        }
    }

    /**
     * Method to convert points to bitcoins. For every 3 points, 1 bitcoin is added to the card.
     * The points are reduced by 3 for each conversion.
     */
    public void convertPointsToBitcoins() {
        while (points >= 3) {
            points -= 3;
            bitcoins++;
        }
    }

    /**
     * Method to check if the card has enough bitcoins for a shuttle journey.
     * A shuttle journey requires at least 4 bitcoins.
     *
     * @return true if the card has enough bitcoins (>= 4), false otherwise
     */
    public boolean hasEnoughCoinsForJourney() {
        return bitcoins >= 4;
    }

    /**
     * Method to update the card after a shuttle journey. It deducts 4 bitcoins
     * and adds 1 point to the card. If there are not enough bitcoins, the update fails.
     *
     * @return true if the journey was successful (update occurred), false if not enough bitcoins
     */
    public boolean updateAfterJourney() {
        if (!hasEnoughCoinsForJourney()) {
            return false;  // Indicate failure due to insufficient bitcoins
        }
        deductBitcoins(4);  // Deduct 4 bitcoins for the journey
        points++;           // Add 1 point for the journey
        return true;        // Indicate success
    }

    /**
     * toString() method to return a string representation of the card's details.
     *
     * @return A string containing the card's ID, name, luxury rating, bitcoins, and points
     */
    @Override
    public String toString() {
        return "Card ID: " + cardId + ", Name: " + name + ", Luxury Rating: " + luxuryRating
                + ", Bitcoins: " + bitcoins + ", Points: " + points;
    }
}
