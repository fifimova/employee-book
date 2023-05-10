package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public List<Employee> employeeBook = new ArrayList<>();
    public final int MAX_QUANTITY = 10;

    @Override
    public void addEmployee(String firstName, String lastName) {
        if (employeeBook.size() >= MAX_QUANTITY) {
            throw new EmployeeStorageIsFullException("В хранилище не может быть больше 10 сотрудников");
        }
        for (Employee employee : employeeBook) {
            if (employee.getFirstName().equals(firstName) && employee.getLastname().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
            }
        }
        employeeBook.add(new Employee(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeBook.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeBook.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        } else {
            employeeBook.remove(employee);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeeBook() {
        return employeeBook;
    }
}
