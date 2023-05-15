package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_QUANTITY = 4;
    public List<Employee> employeeBook = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov"),
            new Employee("Ivan", "Ivanov2"),
            new Employee("Sasha", "Sashina")
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.size() >= MAX_QUANTITY) {
            throw new EmployeeStorageIsFullException("В хранилище не может быть больше 10 сотрудников");
        }
        if (employeeBook.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        }
        employeeBook.add(new Employee(firstName, lastName));
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.contains(employee)) {
            employeeBook.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getEmployeeBook() {
        return Collections.unmodifiableList(employeeBook);
    }
}
