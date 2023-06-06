package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeByDepartmentServiceImpl implements EmployeeByDepartmentService {
    private final EmployeeService employeeService;

    public EmployeeByDepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> findMinSalaryInDepartment(int department) {
        List<Employee> employeeBook = (List<Employee>) employeeService.getEmployeeBook();
        Optional<Employee> employees = employeeBook.stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
        return employees.stream().collect(Collectors.toList());
    }

    @Override
    public List<Employee> findMaxSalaryInDepartment(int department) {
        List<Employee> employeeBook = (List<Employee>) employeeService.getEmployeeBook();
        Optional<Employee> employees = employeeBook.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
        return employees.stream().collect(Collectors.toList());
    }

    @Override
    public List<Employee> printListOfDepartment(int department) {
        List<Employee> employeeBook = (List<Employee>) employeeService.getEmployeeBook();
        return employeeBook.stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> printEmployeesByDepartment() {
        List<Employee> employeeBook = (List<Employee>) employeeService.getEmployeeBook();
        return employeeBook.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
