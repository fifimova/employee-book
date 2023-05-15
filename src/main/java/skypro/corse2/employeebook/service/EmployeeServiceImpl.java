package skypro.corse2.employeebook.service;

import org.springframework.stereotype.Service;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public final int MAX_QUANTITY = 10;
    public Map<Employee, Integer> employeeBook = new HashMap<>(Map.of(
            new Employee("Ivan", "Ivanov"), 1,
            new Employee("Ivan", "Smirnov"), 2,
            new Employee("Sasha", "Smirnov"), 3,
            new Employee("Pasha", "Technic"), 4,
            new Employee("Joshua", "Bloch"), 5
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.size() >= MAX_QUANTITY) {
            throw new EmployeeStorageIsFullException("В хранилище не может быть больше 10 сотрудников");
        }
        if (employeeBook.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник с таким именем уже существует");
        }
        employeeBook.put(new Employee(firstName, lastName), employeeBook.size() + 1);
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeBook.containsKey(employee)) {
            employeeBook.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Set<Employee> getEmployeeBook() {
        return employeeBook.keySet();
    }
}
