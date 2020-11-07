package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] pizzaInfo = reader.readLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
        Pizza pizza;

        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String[] doughInfo = reader.readLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weightInGrams = Double.parseDouble(doughInfo[3]);

        Dough dough;

        try {
            dough = new Dough(flourType, bakingTechnique, weightInGrams);
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        pizza.setDough(dough);

        String input = reader.readLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String toppingType = tokens[1];
            double toppingWeight = Double.parseDouble(tokens[2]);

            Topping topping;

            try {
                topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            input = reader.readLine();
        }

        double totalCalories = pizza.getOverallCalories();

        System.out.println(String.format("%s - %.2f", pizza.getName(), totalCalories));
    }
}
