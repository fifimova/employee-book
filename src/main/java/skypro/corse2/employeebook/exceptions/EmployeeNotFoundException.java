package skypro.corse2.employeebook.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
