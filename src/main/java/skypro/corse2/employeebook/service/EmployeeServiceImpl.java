package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_QUANTITY = 10;
    private final Map<String, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    @Override

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
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
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee.getFullName())) {
            return employeeBook.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Collection<Employee> getEmployeeBook() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }
}
