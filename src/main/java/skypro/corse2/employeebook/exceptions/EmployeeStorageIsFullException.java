package skypro.corse2.employeebook.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus
public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
