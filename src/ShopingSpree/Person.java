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
        boolean validName = NameValidator.validateName(name);
        if (!validName) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void setMoney(double money) {
        boolean validMoney = ValueValidator.validateValue(money);
        if (!validMoney) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            this.products.add(product);
            this.money -= product.getCost();
            System.out.println(String.format("%s bought %s", this.getName(), product.getName()));
        } else {
            System.out.println(String.format("%s can't afford %s", this.getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s - ", this.getName()));

        if (products.size() > 0) {
            result.append(this.products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        } else {
            result.append("Nothing bought");
        }

        return result.toString().trim();
    }
}
