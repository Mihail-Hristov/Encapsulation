package PizzaCalories;

import java.util.Iterator;

public enum ToppingModifiers {
    MEAT("Meat",1.2),
    VEGGIES("Veggies", 0.8),
    CHEESE("Cheese",1.1),
    SAUCE("Sauce",0.9);

    private double calories;
    private String name;

    ToppingModifiers(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }

    public String getName() {
        return this.name;
    }
}
