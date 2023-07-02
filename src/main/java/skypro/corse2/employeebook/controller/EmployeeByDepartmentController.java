package skypro.corse2.employeebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.service.EmployeeByDepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class EmployeeByDepartmentController {

    private final EmployeeByDepartmentService employeeByDepartmentService;

    public EmployeeByDepartmentController(EmployeeByDepartmentService employeeByDepartmentService) {
        this.employeeByDepartmentService = employeeByDepartmentService;
    }

    @GetMapping("/{id}/salary/min")
    public Employee findMinSalaryInDepartment(@PathVariable("id") int department) {
        return employeeByDepartmentService.findMinSalaryInDepartment(department);
    }

    @GetMapping("/{id}/salary/max")
    public Employee findMaxSalaryInDepartment(@PathVariable("id") int department) {
        return employeeByDepartmentService.findMaxSalaryInDepartment(department);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> printListOfDepartment(@PathVariable("id") int department) {
        return employeeByDepartmentService.printListOfDepartment(department);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> printEmployeesByDepartment() {
        return employeeByDepartmentService.printEmployeesByDepartment();
    }

    @GetMapping("/{id}/salary/sum")
    public Integer sumSalaryByDepartment(@PathVariable("id") int department) {
        return employeeByDepartmentService.sumSalaryByDepartment(department);
    }
}
