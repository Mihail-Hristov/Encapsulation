package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            double surfaceArea = box.calculateSurfaceArea();
            double lateralSurfaceArea = box.calculateLateralSurfaceArea();
            double volume = box.calculateVolume();
            System.out.println(String.format("Surface Area - %.2f", surfaceArea));
            System.out.println(String.format("Lateral Surface Area - %.2f", lateralSurfaceArea));
            System.out.println(String.format("Volume - %.2f", volume));
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
