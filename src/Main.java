public class Main {

    /**
     * The main method serves as the entry point for the Resort World Management System.
     * It creates an instance of the ResortUI class and calls the displayMenu method to
     * launch the user interface for interacting with the system.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create an instance of ResortUI to interact with the system
        ResortUI resortUI = new ResortUI();

        // Call the displayMenu method to show the main menu to the user
        resortUI.displayMenu();
    }
}
