package PizzaCalories;

import java.util.Arrays;

public class Dough {
    private static final double DEFAULT_CALORIES_PER_GRAM = 2;

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!isDoughIsValid(flourType)) {
            throw new IllegalArgumentException(String.format("Invalid type of dough."));
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!isDoughIsValid(bakingTechnique)) {
            throw new IllegalArgumentException(String.format("Invalid type of dough."));
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        return (DEFAULT_CALORIES_PER_GRAM * weight)
                * DoughModifiers.valueOf(flourType.toUpperCase()).getCalories()
                * DoughModifiers.valueOf(bakingTechnique.toUpperCase()).getCalories();
    }

    private boolean isDoughIsValid(String type) {
        return type.equals("White") || type.equals("Wholegrain") || type.equals("Crispy") || type.equals("Chewy") || type.equals("Homemade");
    }
}
