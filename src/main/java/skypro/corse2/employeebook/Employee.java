package skypro.corse2.employeebook;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastname;
    private final int department;
    private final int salary;

    public Employee(String firstName, String lastname, int department, int salary) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastname = capitalize(lastname.toLowerCase());
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastname, employee.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastname, department, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastname;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

}

