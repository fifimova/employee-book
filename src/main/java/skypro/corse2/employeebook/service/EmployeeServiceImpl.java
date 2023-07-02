package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;
import skypro.corse2.employeebook.exceptions.WrongDataException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_QUANTITY = 4;
    private final Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        validateInput(firstName, lastName);
        if (employeeBook.size() >= MAX_QUANTITY) {
            throw new EmployeeStorageIsFullException("В хранилище не может быть больше 10 сотрудников");
        }
        if (employeeBook.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        }
        employeeBook.put(employee.getFullName(), employee);
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        validateInput(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        validateInput(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getEmployeeBook() {
        return List.copyOf(employeeBook.values());
    }

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new WrongDataException("Unexpected symbols");
        }
    }
}
