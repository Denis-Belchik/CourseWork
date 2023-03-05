import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        Random random = new Random();

        String[] lastName = {"Иванов", "Федоров", "Петров", "Александров", "Кузмечев"};
        String[] firstName = {"Иван", "Федор", "Петр", "Александр", "Алексей"};
        String[] middleName = {"Иванович", "Федорович", "Петрович", "Александрович", "Алексеевич"};

        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(lastName[random.nextInt(5)] + " " + firstName[random.nextInt(5)] +
                    " " + middleName[random.nextInt(5)],random.nextInt(5) + 1, random.nextInt(50_000) + 50_000);
        }

        printEmployee(employee);
        System.out.println();

        System.out.println("sumSalary(employee) = " + sumSalary(employee));
        System.out.println();

        System.out.println("minSalary(employee) = " + minSalary(employee));
        System.out.println();

        System.out.println("maxSalary(employee) = " + maxSalary(employee));
        System.out.println();

        System.out.println("averageSalary(employee) = " + averageSalary(employee));
        System.out.println();

        printName(employee);

    }

    public static void printEmployee(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            System.out.println("employee[" + i + "] = " + employee[i]);
        }
    }

    public static double sumSalary(Employee[] employees) {
        float sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static double minSalary(Employee[] employees) {
        double min = Integer.MAX_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() < min)
                min = employee.getSalary();
        }
        return min;
    }

    public static double maxSalary(Employee[] employees) {
        double max = Integer.MIN_VALUE;
        for (Employee employee : employees) {
            if (employee.getSalary() > max)
                max = employee.getSalary();
        }
        return max;
    }

    public static double averageSalary(Employee[] employee) {
        return sumSalary(employee) / employee.length;
    }

    public static void printName(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println("ФИО = " + employee.getName());
        }
    }

}