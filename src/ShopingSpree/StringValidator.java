package ShopingSpree;

public class StringValidator {

    private StringValidator() {
    }

    public static boolean isValidName(String name) {
        return !name.trim().isEmpty();
    }
}
