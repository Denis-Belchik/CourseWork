public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.printEmployee();
        System.out.println();

        System.out.println("Удаление сотрудника");
        System.out.println("employeeBook.delete(2) = " + employeeBook.delete(2));
        employeeBook.printEmployee();
        System.out.println();

        System.out.println("Сумма затрат на зарплаты");
        System.out.println("employeeBook.sumSalary() = " + employeeBook.sumSalary());
        System.out.println();

        System.out.println("Сотрудника с минимальной зарплатой");
        System.out.println("employeeBook.minSalary() = " + employeeBook.minSalary());
        System.out.println();

        System.out.println("Сотрудника с максимальной зарплатой");
        System.out.println("employeeBook.maxSalary() = " + employeeBook.maxSalary());
        System.out.println();

        System.out.println("Среднее значение зарплат");
        System.out.println("employeeBook.averageSalary() = " + employeeBook.averageSalary());
        System.out.println();

        employeeBook.printName();
        System.out.println();

        System.out.println("Индексация зарплаты");
        employeeBook.indexSalary(10);
        employeeBook.printEmployee();
        System.out.println();

        System.out.println("Сотрудник с минимальной зарплатой по отделу");
        System.out.println("employeeBook.minSalary(3) = " + employeeBook.minSalary(3));
        System.out.println();

        System.out.println("Сотрудник с максимальной зарплатой по отделу");
        System.out.println("employeeBook.maxSalary(2) = " + employeeBook.maxSalary(2));
        System.out.println();

        System.out.println("Сумма затрат на зарплату по отделу");
        System.out.println("employeeBook.sumSalary(2) = " + employeeBook.sumSalary(2));
        System.out.println();

        System.out.println("Средняя зарплата по отделу");
        System.out.println("employeeBook.averageSalary(2) = " + employeeBook.averageSalary(2));
        System.out.println();

        System.out.println("Индексация зарплаты в отделе");
        System.out.println("employeeBook.indexSalary(4, 10) = " + employeeBook.indexSalary(4, 10));
        employeeBook.printEmployee();
        System.out.println();

        System.out.println("Печать всех сотрудников отдела 1");
        employeeBook.printEmployeeWithoutDepartment(1);
        System.out.println();

        System.out.println("Всех сотрудников с зарплатой меньше числа");
        employeeBook.printMinSalaryForValue(80000);
        System.out.println();

        System.out.println("Всех сотрудников с зарплатой больше числа");
        employeeBook.printMaxSalaryForValue(70000);
        System.out.println();

        System.out.println("Добавление сотрудника");
        System.out.println("employeeBook.add(\"Иван Васильевич\", 4, 50000) = " + employeeBook.add("Иван Васильевич", 4, 50000));
        System.out.println("employeeBook.add(\"Иван Васильевич\", 5, 5000) = " + employeeBook.add("Иван Васильевич", 5, 5000));
        employeeBook.printEmployee();
        System.out.println();

        System.out.println("Изменение зарплаты сотрудника");
        System.out.println("employeeBook.changeSalary(9, 20000) = " + employeeBook.changeSalary(9, 20000));
        System.out.println();

        System.out.println("Изменение отдела сотрудника");
        System.out.println("employeeBook.changeDepartment(8,4) = " + employeeBook.changeDepartment(8, 4));
        System.out.println();

        System.out.println("Печать сотрудников по отделам");
        employeeBook.printEmployeeInDeportment();
        System.out.println();
    }
}