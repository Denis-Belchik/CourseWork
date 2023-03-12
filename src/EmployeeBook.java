import java.util.Random;

public class EmployeeBook {
    private final Employee[] employee;
    private final int department = 5;

    public EmployeeBook(int length) {
        employee = new Employee[length];
        Random random = new Random();
        String[] lastName = {"Иванов", "Федоров", "Петров", "Александров", "Кузмечев"};
        String[] firstName = {"Иван", "Федор", "Петр", "Александр", "Алексей"};
        String[] middleName = {"Иванович", "Федорович", "Петрович", "Александрович", "Алексеевич"};
        for (int i = 0; i < employee.length; i++) {
            employee[i] = new Employee(lastName[random.nextInt(lastName.length)] + " " + firstName[random.nextInt(firstName.length)] +
                    " " + middleName[random.nextInt(middleName.length)], random.nextInt(department) + 1, random.nextDouble() * 50_000 + 50_000);
        }
    }

    public void printMaxSalaryForValue(double value) {
        for (Employee val : employee) {
            if (val != null && val.getSalary() >= value) {
                System.out.println(val);
            }
        }
    }

    public void printMinSalaryForValue(double value) {
        for (Employee val : employee) {
            if (val != null && val.getSalary() <= value) {
                System.out.println(val);
            }
        }
    }

    public void printEmployeeWithoutDepartment(int department) {
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department)
                System.out.println(val);
        }
    }

    public void printEmployeeInDeportment() {
        for (int i = 1; i <= department; i++) {
            int flag = 0;
            for (Employee val : employee) {
                if (val != null && val.getDepartment() == i) {
                    flag++;
                    if (flag == 1) {
                        System.out.println("Отдел " + i);
                    }
                    System.out.println(val);
                }
            }
        }
    }

    public void printEmployee() {
        for (int i = 0; i < employee.length; i++) {
            System.out.println("employee[" + i + "] = " + employee[i]);
        }
    }

    public void printName() {
        for (Employee val : employee) {
            if (val != null)
                System.out.println("ФИО = " + val.getName());
        }
    }

    public Employee changeDepartment(int id, int department) {
        if (department > this.department || department < 1) return null;
        for (Employee value : employee) {
            if (value != null && value.getId() == id) {
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
        if (department > this.department || department < 1) return null;
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

    public boolean indexSalary(int department, double percent) {
        if (department > this.department || department < 1) return false;
        boolean isIndex = false;
        for (Employee val : employee) {
            if (val != null && department == val.getDepartment()) {
                isIndex = true;
                val.setSalary(val.getSalary() + val.getSalary() * percent / 100);
            }
        }
        return isIndex;
    }

    public void indexSalary(double percent) {
        for (Employee val : employee) {
            if (val != null)
                val.setSalary(val.getSalary() + val.getSalary() * percent / 100);
        }
    }

    public double averageSalary(int department) {
        if (department > this.department || department < 1) return -1;
        int count = 0;
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department) {
                count++;
            }
        }
        return sumSalary(department) / count;
    }

    public double averageSalary() {
        int count = 0;
        for (Employee val : employee) {
            if (val != null) {
                count++;
            }
        }
        return sumSalary() / count;
    }

    public double sumSalary(int department) {
        if (department > this.department || department < 1) return -1;
        float sum = 0;
        for (Employee val : employee) {
            if (val != null && val.getDepartment() == department)
                sum += val.getSalary();
        }
        return sum;
    }

    public double sumSalary() {
        float sum = 0;
        for (Employee val : employee) {
            if (val != null)
                sum += val.getSalary();
        }
        return sum;
    }

    public Employee maxSalary(int department) {
        if (department > this.department || department < 1) return null;
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

    public Employee minSalary(int department) {
        if (department > this.department || department < 1) return null;
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
}
