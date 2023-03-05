import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        Random random = new Random();

        String[] lastName = {"Иванов", "Федоров", "Петров", "Александров", "Кузмечев"};
        String[] firstName = {"Иван", "Федор", "Петр", "Александр", "Алексей"};
        String[] middleName = {"Иванович", "Федорович", "Петрович", "Александрович", "Алексеевич"};

        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(lastName[random.nextInt(lastName.length)] + " " + firstName[random.nextInt(firstName.length)] +
                    " " + middleName[random.nextInt(middleName.length)], random.nextInt(5) + 1, random.nextInt(50_000) + 50_000);
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
        System.out.println();

        indexSalary(employee, 10);
        printEmployee(employee);
        System.out.println();

        System.out.println("minSalary(employee, 3) = " + minSalary(employee, 3));
        System.out.println();

        System.out.println("maxSalary(employee, 2) = " + maxSalary(employee, 2));
        System.out.println();

        System.out.println("sumSalary(employee, 2) = " + sumSalary(employee, 2));
        System.out.println();

        System.out.println("averageSalary(employee, 2) = " + averageSalary(employee, 2));
        System.out.println();

        indexSalary(employee, 3,10);
        printEmployee(employee);
        System.out.println();

        printEmployeeWithoutDepartment(employee, 1);
        System.out.println();

        printMinSalaryForValue(employee, 80000);
        System.out.println();

        printMaxSalaryForValue(employee, 70000);
        System.out.println();
    }

    public static void printMaxSalaryForValue(Employee[] employees, double value) {
        for (Employee employee : employees) {
            if (employee.getSalary() >= value) {
                System.out.println("ID: " + employee.getId() + ", имя: " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printMinSalaryForValue(Employee[] employees, double value) {
        for (Employee employee : employees) {
            if (employee.getSalary() <= value) {
                System.out.println("ID: " + employee.getId() + ", имя: " + employee.getName() + ", зарплата: " + employee.getSalary());
            }
        }
    }

    public static void printEmployeeWithoutDepartment(Employee[] employee, int department) {
        for (Employee value : employee) {
            if (value.getDepartment() == department)
                System.out.println("ID: " + value.getId() + ", имя: " + value.getName() + ", зарплата: " + value.getSalary());
        }
    }

    public static void indexSalary(Employee[] employees, int department, double percent) {
        for (Employee employee : employees) {
            if (department == employee.getDepartment())
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    public static double averageSalary(Employee[] employees, int department) {
        float sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public static double sumSalary(Employee[] employees, int department) {
        float sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment() == department)
                sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee maxSalary(Employee[] employees, int department) {
        double max = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max && employee.getDepartment() == department) {
                max = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public static Employee minSalary(Employee[] employees, int department) {
        double min = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < min && employee.getDepartment() == department) {
                min = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static void indexSalary(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
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

    public static Employee minSalary(Employee[] employees) {
        double min = Integer.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public static Employee maxSalary(Employee[] employees) {
        double max = Integer.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
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