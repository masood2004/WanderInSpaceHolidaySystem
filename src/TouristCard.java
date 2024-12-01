public class TouristCard extends Card {
    private int luxuryRating;
    private int bitcoins;
    private String citizenship;

    /**
     * Constructor for the TouristCard.
     * @param luxuryRating The luxury rating of the card.
     * @param bitcoins The number of bitcoins based on the luxury rating.
     * @param citizenship The citizenship (planet) of the cardholder.
     */
    public TouristCard(int luxuryRating, int bitcoins, String citizenship) {
        super(luxuryRating, "Tourist Card", bitcoins, 0);  // Calls the superclass constructor
        this.luxuryRating = luxuryRating;
        this.bitcoins = bitcoins;
        this.citizenship = citizenship;
    }

    /**
     * Override toString() to include subclass-specific details.
     * @return A string representation of the TouristCard.
     */
    @Override
    public String toString() {
        return super.toString() + ", Luxury Rating: " + luxuryRating + ", Bitcoins: " + bitcoins + ", Citizenship: " + citizenship;
    }
}
