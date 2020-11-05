package ValidationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName.length() >= 3) {
            this.firstName = firstName;
        }else {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() >= 3) {
            this.lastName = lastName;
        }else {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }else {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
    }

    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        if (salary >= 460.0) {
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
