abstract class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;

    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name =" + name + ", id=" + id + ".salary=" + calculateSalary() + "]";
    }
}

class fullTimeEmployee extends Employee {
    private double monthlySalary;

    public fullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }

}

class partTimeEmployee extends Employee {
    private int hoursWork;
    private double hourlyRate;

    public partTimeEmployee(String name, int id, int hoursWork, double hourlyRate) {
        super(name, id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;

    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWork;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
