package ShopingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInfo = scanner.nextLine().split(";");
        String[] productInfo = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        try {
            Arrays.stream(personInfo)
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        String name = tokens[0];
                        double money = Double.parseDouble(tokens[1]);
                        people.put(name, new Person(name, money));
                    });
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try {
            Arrays.stream(productInfo)
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        String name = tokens[0];
                        double cost = Double.parseDouble(tokens[1]);
                        products.put(name, new Product(name, cost));
                    });
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }


        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            String person = tokens[0];
            String product = tokens[1];

            people.get(person).buyProduct(products.get(product));

            input = scanner.nextLine();
        }

        for (Person person : people.values()) {
            System.out.println(person);
        }
    }
}
