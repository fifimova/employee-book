package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class EmployeeByDepartmentServiceImpl implements EmployeeByDepartmentService {
    private final EmployeeService employeeService;

    public EmployeeByDepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMinSalaryInDepartment(int department) {
        return employeeService.getEmployeeBook().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("no employee"));
    }

    @Override
    public Employee findMaxSalaryInDepartment(int department) {
        return employeeService.getEmployeeBook().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("no employee"));
    }

    @Override
    public List<Employee> printListOfDepartment(int department) {
        return employeeService.getEmployeeBook().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> printEmployeesByDepartment() {
        return employeeService.getEmployeeBook()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Integer sumSalaryByDepartment(int department) {
        return employeeService.getEmployeeBook().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }
}
