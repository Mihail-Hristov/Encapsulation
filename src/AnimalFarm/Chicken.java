package AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name != null && !name.equals("") && !name.equals("\\s+")) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    public  String getName() {
        return this.name;
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        }else throw new IllegalArgumentException("Age should be between 0 and 15.");
    }

    public int getAge() {
        return this.age;
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        double result = 0.0;
        if (this.getAge() < 6) {
            result = 2.0;
        }else if (this.getAge() >= 6 && this.getAge() <= 11) {
            result = 1.0;
        }else if (this.getAge() >= 12) {
            result = 0.75;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.%n", getName(), getAge(), productPerDay());
    }
}
