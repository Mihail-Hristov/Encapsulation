package ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!StringValidator.isValidName(name)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_MESSAGE_FOR_INVALID_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setMoney(double money) {
        if (!AmountValidator.IsNotNegativeAmount(money)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_MESSAGE_FOR_INCORRECT_AMOUNT);
        }
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.getName()).append(" - ");
        if (this.products.isEmpty()){
            result.append("Nothing bought");
        }else {
            result.append(this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        }
        return result.toString();
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            this.products.add(product);
            System.out.println(String.format("%s bought %s", this.getName(), product.getName()));
            this.money -= product.getCost();
        }else {
            System.out.println(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }
}
