package ShopingSpree;

public class AmountValidator {

    private AmountValidator() {
    }

    public static boolean IsNotNegativeAmount(double amount) {
        return amount >= 0;
    }
}
