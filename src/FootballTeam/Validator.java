package FootballTeam;

public class Validator {

    private Validator() {
    }

    public static void validName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validRange(int number, String stat) {
        if (number < 0 || number > 100) {
            throw new IllegalArgumentException(stat + " should be between 0 and 100.");
        }
    }
}
