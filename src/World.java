import java.util.ArrayList;

/**
 * The World class represents a world in the resort system, containing a number of cards and various attributes such as
 * luxury rating, capacity, and world number.
 *
 * This class provides methods for adding/removing cards, checking the world's status (full or not),
 * and converting points to bitcoins for all cards on the world.
 *
 * It also includes accessor methods for retrieving world information and a toString() method to provide a string
 * representation of the world and the cards it contains.
 *
 * @author (your name)
 * @version (version number or date)
 */
public class World {

    // Instance variables
    private int worldNumber;   // The unique identifier for this world
    private String name;       // The name of the world
    private int luxuryRating;  // The luxury rating of the world
    private int capacity;      // The maximum number of cards that can be on this world
    private ArrayList<Card> cardsOnWorld; // List of cards currently in the world

    /**
     * Constructor to initialize the world object with specific values.
     *
     * @param worldNumber   The unique identifier for the world
     * @param name          The name of the world
     * @param luxuryRating  The luxury rating of the world
     * @param capacity      The maximum number of cards this world can hold
     */
    public World(int worldNumber, String name, int luxuryRating, int capacity) {
        this.worldNumber = worldNumber;
        this.name = name;
        this.luxuryRating = luxuryRating;
        this.capacity = capacity;
        this.cardsOnWorld = new ArrayList<>();  // Initialize the list of cards on the world
    }

    /**
     * Accessor method to get the world number.
     *
     * @return The unique number of the world
     */
    public int getWorldNumber() {
        return worldNumber;
    }

    /**
     * Accessor method to get the name of the world.
     *
     * @return The name of the world
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method to get the luxury rating of the world.
     *
     * @return The luxury rating of the world
     */
    public int getLuxuryRating() {
        return luxuryRating;
    }

    /**
     * Method to check if the world has reached its maximum capacity.
     *
     * @return true if the world is full, false otherwise
     */
    public boolean isFull() {
        return cardsOnWorld.size() >= capacity;
    }

    /**
     * Method to add a card to the world.
     *
     * @param card The card to be added to the world
     * @return true if the card was successfully added, false if the world is full
     */
    public boolean arrive(Card card) {
        if (!isFull()) {
            cardsOnWorld.add(card);
            return true;  // Successfully added the card
        } else {
            return false;  // The world is full, so card cannot be added
        }
    }

    /**
     * Method to remove a card from the world.
     *
     * @param card The card to be removed from the world
     */
    public void leave(Card card) {
        cardsOnWorld.remove(card);
    }

    /**
     * Method to find a card on the world by its unique card ID.
     *
     * @param cardId The ID of the card to find
     * @return The Card object if found, null otherwise
     */
    public Card findCardById(int cardId) {
        for (Card card : cardsOnWorld) {
            if (card.getCardId() == cardId) {
                return card;  // Card found with the matching ID
            }
        }
        return null;  // No card found with the specified ID
    }

    /**
     * Method to convert all points of cards in the world to bitcoins.
     * The conversion is based on the card's internal logic for converting points to bitcoins.
     */
    public void convertAllPointsToBitcoins() {
        for (Card card : cardsOnWorld) {
            card.convertPointsToBitcoins();  // Convert points for each card in the world
        }
    }

    /**
     * Override the toString() method to return a string representation of the world and the cards within it.
     *
     * @return A string representing the world details and the list of cards on this world
     */
    @Override
    public String toString() {
        StringBuilder worldDetails = new StringBuilder();
        worldDetails.append("World Number: " + worldNumber + ", Name: " + name + ", Luxury Rating: " + luxuryRating + "\n");
        worldDetails.append("Cards in this world: \n");
        for (Card card : cardsOnWorld) {
            worldDetails.append(card.toString() + "\n");  // Append each card's details
        }
        return worldDetails.toString();
    }
}
