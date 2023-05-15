package skypro.corse2.employeebook.service;

import skypro.corse2.employeebook.Employee;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);


    Set<Employee> getEmployeeBook();
}
