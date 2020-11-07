package ShopingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_MESSAGE_FOR_INVALID_NAME);
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if (!AmountValidator.IsNotNegativeAmount(cost)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_MESSAGE_FOR_INCORRECT_AMOUNT);
        }
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}
