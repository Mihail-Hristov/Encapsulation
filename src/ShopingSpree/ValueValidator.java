package ShopingSpree;

public class ValueValidator {

    public static boolean validateValue(double value) {
        if (value < 0.0) {
            return false;
        }
        return true;
    }
}
