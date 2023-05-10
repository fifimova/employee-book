package skypro.corse2.employeebook.service;

import skypro.corse2.employeebook.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);


    List<Employee> getEmployeeBook();
}
