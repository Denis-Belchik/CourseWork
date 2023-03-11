public class Employee {
    private static int counter = 0;
    private final int id;
    private String name;
    private int department;
    private double salary;

    public Employee(String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = counter;
        counter++;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", имя: " + name + ", отдел: " + department + ", зарплата: " + salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
