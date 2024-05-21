import java.util.ArrayList;
import java.util.Scanner;

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

class PayrollSystem {

    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {

        Employee employeeToRemove = null;

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        PayrollSystem payrollSystem = new PayrollSystem();
        int id;
        String name;
        double salary;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Display Employees");
            System.out.print("Enter your choice: ");
            int ch = input.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter id");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter name");
                    name = input.nextLine();
                    System.out.println("Enter name salary");
                    salary = input.nextInt();

                    fullTimeEmployee emp1 = new fullTimeEmployee(name, id, salary);
                    payrollSystem.addEmployee(emp1);

                    break;

                case 2:
                    System.out.println("Enter id");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter name");
                    name = input.nextLine();
                    System.out.println("Enter  hours work");
                    int hoursWork = input.nextInt();
                    System.out.println("Enter hourly rate");
                    int hourlyRate = input.nextInt();

                    partTimeEmployee emp2 = new partTimeEmployee(name, id, hoursWork, hourlyRate);
                    payrollSystem.addEmployee(emp2);

                    break;

                case 3:
                    System.out.print("Enter employee ID to remove: ");
                    int employeeIdToRemove = input.nextInt();
                    payrollSystem.removeEmployee(employeeIdToRemove);
                    break;

                case 4:
                    payrollSystem.displayEmployee();
                    break;
                default:
                    break;
            }

        }

    }
}
