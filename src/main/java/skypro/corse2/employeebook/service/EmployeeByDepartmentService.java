package skypro.corse2.employeebook.service;

import skypro.corse2.employeebook.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeByDepartmentService {


    Employee findMinSalaryInDepartment(int department);

    Employee findMaxSalaryInDepartment(int department);

    List<Employee> printListOfDepartment(int department);


    Map<Integer, List<Employee>> printEmployeesByDepartment();

    Integer sumSalaryByDepartment(int department);
}
