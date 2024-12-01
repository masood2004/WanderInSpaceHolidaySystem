public interface WISH {
    void addCard(Card card);  // Add a card to a world
    void displayWorldDetails();  // Display details of the world(s)
    boolean checkJourneyFeasibility(Card card, World destination);  // Check if a card can travel to a specific world
    Resort.JourneyStatus executeShuttleJourney(Card card, Shuttle shuttle);  // Execute a shuttle journey for a given card
    void convertPointsToBitcoins();  // Convert points to bitcoins for the worlds
    Resort.CardDetailsResult showCardDetails(int cardId);  // Display the details of a card by ID
}
