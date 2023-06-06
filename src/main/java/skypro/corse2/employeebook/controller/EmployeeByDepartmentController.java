package skypro.corse2.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.service.EmployeeByDepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeByDepartmentController {

    private final EmployeeByDepartmentService employeeByDepartmentService;

    public EmployeeByDepartmentController(EmployeeByDepartmentService employeeByDepartmentService) {
        this.employeeByDepartmentService = employeeByDepartmentService;
    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryInDepartment(@RequestParam("departmentId") int department) {
        return employeeByDepartmentService.findMinSalaryInDepartment(department);
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam("departmentId") int department) {
        return employeeByDepartmentService.findMaxSalaryInDepartment(department);
    }

    @GetMapping("/all-by-department")
    public List<Employee> printListOfDepartment(@RequestParam("departmentId") int department) {
        return employeeByDepartmentService.printListOfDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> printEmployeesByDepartment() {
        return employeeByDepartmentService.printEmployeesByDepartment();
    }
}
