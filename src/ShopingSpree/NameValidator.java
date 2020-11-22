package ShopingSpree;

public class NameValidator {

    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }
}
