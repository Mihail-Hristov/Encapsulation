package PizzaCalories;

public enum DoughModifiers {
    WHITE("White", 1.5),
    WHOLEGRAIN("Wholegrain", 1.0),
    CRISPY("Crispy", 0.9),
    CHEWY("Chewy", 1.1),
    HOMEMADE("Homemade", 1.0);

    private String name;
    private double calories;

    DoughModifiers(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return this.name;
    }

    public double getCalories() {
        return this.calories;
    }

}
