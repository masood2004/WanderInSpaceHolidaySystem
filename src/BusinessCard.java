public class BusinessCard extends Card {
    private int luxuryRating;
    private int bitcoins = 30;  // Always 30 bitcoins
    private int freeDrinks = 10;  // Starts with 10 free drinks

    /**
     * Constructor for the BusinessCard.
     * @param luxuryRating The luxury rating of the card.
     */
    public BusinessCard(int luxuryRating) {
        super(luxuryRating, "Business Card", 30, 0);  // Calls the superclass constructor
        this.luxuryRating = luxuryRating;
    }

    /**
     * Deduct 1 free drink for each shuttle journey.
     * @return True if a free drink was deducted, false if there are no drinks left.
     */
    public boolean deductFreeDrink() {
        if (freeDrinks > 0) {
            freeDrinks--;
            return true;
        }
        return false;
    }

    /**
     * Override toString() to include subclass-specific details.
     * @return A string representation of the BusinessCard.
     */
    @Override
    public String toString() {
        return super.toString() + ", Luxury Rating: " + luxuryRating + ", Bitcoins: " + bitcoins + ", Free Drinks Remaining: " + freeDrinks;
    }
}
