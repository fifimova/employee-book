package skypro.corse2.employeebook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.corse2.employeebook.Employee;
import skypro.corse2.employeebook.exceptions.EmployeeAlreadyAddedException;
import skypro.corse2.employeebook.exceptions.EmployeeNotFoundException;
import skypro.corse2.employeebook.exceptions.EmployeeStorageIsFullException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private EmployeeService out = new EmployeeServiceImpl();

    @BeforeEach
    void setUp() {
        out.addEmployee("Sasha", "Sasha", 1, 10000);
        out.addEmployee("Pasha", "Pasha", 5, 10001);
        out.addEmployee("Ivan", "Ivan", 3, 10002);

    }

    @Test
    void isEmployeeAdded() {
        Employee employee = new Employee("Dasha", "dasha", 4, 1000);
        out.addEmployee("Dasha", "dasha", 4, 1000);
        assertTrue(out.getEmployeeBook().contains(employee));
    }

    @Test
    void isTheSameEmployeesAdded() {
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                out.addEmployee("Sasha", "Sasha", 1, 10000));
    }

    @Test
    void doesExceptionThrowOverFourEmployees() {
        out.addEmployee("A", "B", 1, 1);
        assertThrows(EmployeeStorageIsFullException.class, () ->
                out.addEmployee("C", "D", 4, 3));
    }

    @Test
    void isEmployeeFound() {
        Employee actual = out.findEmployee("Sasha", "Sasha", 1, 10000);
        assertEquals("Sasha", actual.getFirstName());
        assertNotNull(actual);
    }

    @Test
    void doesExceptionThrowWhenFindingNullEmployee() {
        assertThrows(EmployeeNotFoundException.class, () ->
                out.findEmployee("Lana", "Banana", 1, 10));
    }

    @Test
    void isEmployeeRemoved() {
        Employee actual = out.removeEmployee("Sasha", "Sasha", 1, 10000);
        assertNull(actual);
    }

    @Test
    void doesExceptionThrowWhenEmployeeIsNull() {
        assertThrows(EmployeeNotFoundException.class, () ->
                out.removeEmployee("Lana", "Banana", 1, 10));
    }
}