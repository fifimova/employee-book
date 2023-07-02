package skypro.corse2.employeebook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.corse2.employeebook.Employee;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeByDepartmentServiceImplTest {

    @Mock
    private EmployeeService serviceMock;

    @InjectMocks
    private EmployeeByDepartmentServiceImpl out;

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        Employee actual = out.findMinSalaryInDepartment(5);
        assertEquals(10000, actual.getSalary());
    }

    @Test
    void shouldReturnExceptionWithNullEmployeeForMinAndMax() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        assertThrows(IllegalArgumentException.class, () -> out.findMinSalaryInDepartment(2));
        assertThrows(IllegalArgumentException.class, () -> out.findMaxSalaryInDepartment(4));
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        Employee actual = out.findMaxSalaryInDepartment(5);
        assertEquals(10001, actual.getSalary());
    }

    @Test
    void shouldReturnListOfDepartment() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        List<Employee> actual = out.printListOfDepartment(5);
        assertEquals(2, actual.size());
    }

    @Test
    void shouldItPrintEmployeesByDepartment() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        Map<Integer, List<Employee>> result = out.printEmployeesByDepartment();
        assertEquals(2, result.get(5).size());
        assertEquals(1, result.get(3).size());
    }

    @Test
    void shouldReturnSumSalaryByDepartment() {
        when(serviceMock.getEmployeeBook()).thenReturn(generateEmployee());
        assertEquals(20001, out.sumSalaryByDepartment(5));
        assertEquals(10002, out.sumSalaryByDepartment(3));
    }

    private List<Employee> generateEmployee() {
        return List.of(new Employee("Sasha", "Sasha", 5, 10000),
                new Employee("Pasha", "Pasha", 5, 10001),
                new Employee("Ivan", "Ivan", 3, 10002));
    }
}
