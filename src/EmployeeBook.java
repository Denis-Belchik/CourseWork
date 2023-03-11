import java.util.Random;

public class EmployeeBook {
    private final Employee[] employee;

    public EmployeeBook(int length) {
        employee = new Employee[length];
        Random random = new Random();
        String[] lastName = {"Иванов", "Федоров", "Петров", "Александров", "Кузмечев"};
        String[] firstName = {"Иван", "Федор", "Петр", "Александр", "Алексей"};
        String[] middleName = {"Иванович", "Федорович", "Петрович", "Александрович", "Алексеевич"};
        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(lastName[random.nextInt(lastName.length)] + " " + firstName[random.nextInt(firstName.length)] +
                    " " + middleName[random.nextInt(middleName.length)], random.nextInt(5) + 1, random.nextDouble(50_000) + 50_000);
        }
    }

    public void printEmployeeInDeportment() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i);
            for (Employee val : employee) {
                if (val.getDepartment() == i) {
                    System.out.println("ID: " + val.getId() + ", имя: " + val.getName() + ", зарплата: " + val.getSalary());
                }
            }
        }
    }

    public Employee changeDepartment(int id, int department) {
        for (Employee value : employee) {
            if (value != null && value.getId() == id && department <= 5 && department >= 1) {
                value.setDepartment(department);
                return value;
            }
        }
        return null;
    }

    public Employee changeSalary(int id, double salary) {
        for (Employee value : employee) {
            if (value != null && value.getId() == id) {
                value.setSalary(salary);
                return value;
            }
        }
        return null;
    }

    public Employee add(String name, int department, double salary) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                Employee val = new Employee(name, department, salary);
                employee[i] = val;
                return val;
            }
        }
        return null;
    }

    public boolean delete(int id) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && id == employee[i].getId()) {
                employee[i] = null;
                return true;
            }
        }
        return false;
    }

    public void printMaxSalaryForValue(double value) {
        for (Employee val : employee) {
            if (val != null && val.getSalary() >= value) {
                System.out.println("ID: " + val.getId() + ", имя: " + val.getName() + ", зарплата: " + val.getSalary());
            }
        }
    }

    public void printMinSalaryForValue(double value) {
        for (Employee val : employee) {
            if (val != null && val.getSalary() <= value) {
                System.out.println("ID: " + val.getId() + ", имя: " + val.getName() + ", зарплата: " + val.getSalary());
            }
        }
    }

    public void printEmployeeWithoutDepartment(int department) {
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department)
                System.out.println("ID: " + val.getId() + ", имя: " + val.getName() + ", зарплата: " + val.getSalary());
        }
    }

    public boolean indexSalary(int department, double percent) {
        boolean isIndex = false;
        for (Employee val : employee) {
            if (val != null && department == val.getDepartment()) {
                isIndex = true;
                val.setSalary(val.getSalary() + val.getSalary() * percent / 100);
            }
        }
        return isIndex;
    }

    public double averageSalary(int department) {
        float sum = 0;
        int count = 0;
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department) {
                sum += val.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public double averageSalary() {
        float sum = 0;
        int count = 0;
        for (Employee val : employee) {
            if (val != null) {
                sum += val.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    public double sumSalary() {
        float sum = 0;
        for (Employee val : employee) {
            if (val != null)
                sum += val.getSalary();
        }
        return sum;
    }

    public double sumSalary(int department) {
        float sum = 0;
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department)
                sum += val.getSalary();
        }
        return sum;
    }

    public Employee maxSalary(int department) {
        double max = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee val : employee) {
            if (val != null && val.getSalary() > max && val.getDepartment() == department) {
                max = val.getSalary();
                maxSalaryEmployee = val;
            }
        }
        return maxSalaryEmployee;
    }

    public Employee minSalary(int department) {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee val : employee) {
            if (val != null && val.getSalary() < min && val.getDepartment() == department) {
                min = val.getSalary();
                minSalaryEmployee = val;
            }
        }
        return minSalaryEmployee;
    }

    public void indexSalary(double percent) {
        for (Employee val : employee) {
            if (val != null)
                val.setSalary(val.getSalary() + val.getSalary() * percent / 100);
        }
    }

    public void printEmployee() {
        for (int i = 0; i < employee.length; i++) {
            System.out.println("employee[" + i + "] = " + employee[i]);
        }
    }

    public Employee minSalary() {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (Employee val : employee) {
            if (val != null && val.getSalary() < min) {
                min = val.getSalary();
                minSalaryEmployee = val;
            }
        }
        return minSalaryEmployee;
    }

    public Employee maxSalary() {
        double max = Double.MIN_VALUE;
        Employee maxSalaryEmployee = null;
        for (Employee val : employee) {
            if (val != null && val.getSalary() > max) {
                max = val.getSalary();
                maxSalaryEmployee = val;
            }
        }
        return maxSalaryEmployee;
    }

    public void printName() {
        for (Employee val : employee) {
            if (val != null)
                System.out.println("ФИО = " + val.getName());
        }
    }
}
