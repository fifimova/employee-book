package skypro.corse2.employeebook.service;

import skypro.corse2.employeebook.Employee;

import java.util.List;

public interface EmployeeByDepartmentService {
    Employee findMinSalaryInDepartment(int department);

    Employee findMaxSalaryInDepartment(int department);

    List<Employee> printListOfDepartment(int department);

    List<Employee> printEmployeesByDepartment();
}
