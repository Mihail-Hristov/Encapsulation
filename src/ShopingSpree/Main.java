package ShopingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = null;
        Map<String, Product> products = null;

        try {
            people = readPeople(scanner);
            products = readProducts(scanner);
        }catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] token = input.split("\\s+");
            String name = token[0];
            String productName = token[1];

            people.get(name).buyProduct(products.get(productName));

            input = scanner.nextLine();
        }

        for (Person person : people.values()) {
            System.out.println(person);
        }
    }

    public static Map<String, Person> readPeople(Scanner scanner) {
        String[] peopleInfo = scanner.nextLine().split(";");
        Map<String, Person> peopleForReturn = new LinkedHashMap<>();

        for (String people : peopleInfo) {
            String[] tokens = people.split("=");
            Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
            peopleForReturn.put(tokens[0], person);
        }

        return peopleForReturn;
    }

    private static Map<String, Product> readProducts(Scanner scanner) {
        String[] productInfo = scanner.nextLine().split(";");
        Map<String, Product> productsForReturn = new LinkedHashMap<>();

        for (String product : productInfo) {
            String[] tokens = product.split("=");
            Product currentProduct = new Product(tokens[0], Double.parseDouble(tokens[1]));
            productsForReturn.put(tokens[0], currentProduct);
        }

        return productsForReturn;
    }
}
