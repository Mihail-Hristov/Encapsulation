package SalaryIncrease;

public class Person2 {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person2(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.getAge() < 30) {
            bonus /= 2;
        }
        this.salary = this.getSalary() * (1 + (bonus / 100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.2f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
