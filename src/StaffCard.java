public class StaffCard extends Card {
    private int luxuryRating = 10;  // Staff can visit all worlds
    private int bitcoins = 0;  // Always 0 bitcoins
    private int employeeNumber;
    private String jobDescription;
    private int journeyScore = 0;

    /**
     * Constructor for the StaffCard.
     * @param employeeNumber The employee's unique number.
     * @param jobDescription The job description of the employee.
     */
    public StaffCard(int employeeNumber, String jobDescription) {
        super(10, "Staff Card", 0, 0);  // Calls the superclass constructor
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
    }

    /**
     * Add 1 to the journey score whenever a shuttle journey is made.
     */
    public void addJourneyScore() {
        journeyScore++;
    }

    /**
     * Override toString() to include subclass-specific details.
     * @return A string representation of the StaffCard.
     */
    @Override
    public String toString() {
        return super.toString() + ", Employee Number: " + employeeNumber + ", Job: " + jobDescription + ", Journey Score: " + journeyScore;
    }
}
