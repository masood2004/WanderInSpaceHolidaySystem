public class Shuttle {

    // Instance variables
    private String journeyCode;  // The unique code identifying this shuttle journey
    private World sourceWorld;   // The source world where the journey starts
    World destinationWorld;     // The destination world where the journey ends

    /**
     * Constructor to initialize the shuttle with a journey code, source world, and destination world.
     *
     * @param journeyCode        The unique identifier for the shuttle journey
     * @param sourceWorld        The source world where the card is starting the journey
     * @param destinationWorld   The destination world where the card is traveling to
     */
    public Shuttle(String journeyCode, World sourceWorld, World destinationWorld) {
        this.journeyCode = journeyCode;
        this.sourceWorld = sourceWorld;
        this.destinationWorld = destinationWorld;
    }

    /**
     * Inner class to represent the travel status of a card on a shuttle.
     * Contains information about whether the journey can proceed and a message explaining the status.
     */
    public class TravelStatus {
        private boolean canTravel;  // Whether the card can travel on the shuttle
        private String message;     // Message explaining why or why not the card can travel

        /**
         * Constructor to initialize the travel status.
         *
         * @param canTravel   Whether the card can travel
         * @param message     Message explaining the travel status
         */
        public TravelStatus(boolean canTravel, String message) {
            this.canTravel = canTravel;
            this.message = message;
        }

        /**
         * Accessor method to get whether the card can travel.
         *
         * @return true if the card can travel, false otherwise
         */
        public boolean canTravel() {
            return canTravel;
        }

        /**
         * Accessor method to get the message associated with the travel status.
         *
         * @return The message explaining the status
         */
        public String getMessage() {
            return message;
        }
    }

    /**
     * Method to check if a card can travel on this shuttle.
     * The card must meet several conditions: luxury rating, space in the destination world, and enough bitcoins.
     *
     * @param card The card trying to travel on this shuttle
     * @return true if the card can travel, false otherwise
     */
    public boolean canTravel(Card card) {
        // Check if card's luxury rating meets the destination world rating
        if (card.getLuxuryRating() < destinationWorld.getLuxuryRating()) {
            return new TravelStatus(false, "Card's luxury rating is too low for this world.").canTravel();
        }

        // Check if the destination world has space for the card
        if (destinationWorld.isFull()) {
            return new TravelStatus(false, "Destination world is full.").canTravel();
        }

        // Check if the card has enough bitcoins
        if (!card.hasEnoughCoinsForJourney()) {
            return new TravelStatus(false, "Not enough bitcoins for journey.").canTravel();
        }

        // If all checks pass, return true
        return new TravelStatus(true, "Card can travel.").canTravel();
    }

    /**
     * Method to process the card's journey if it can travel.
     * Moves the card from the source world to the destination world and updates the card after the journey.
     *
     * @param card The card to process the journey for
     * @return A message indicating the result of the journey (success or failure)
     */
    public String processJourney(Card card) {
        if (canTravel(card)) {
            sourceWorld.leave(card);  // Remove card from source world
            destinationWorld.arrive(card);  // Add card to destination world
            card.updateAfterJourney();  // Update card after journey
            return "Journey successful from " + sourceWorld.getName() + " to " + destinationWorld.getName();
        } else {
            return "Journey failed.";
        }
    }
}
