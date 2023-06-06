package skypro.corse2.employeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongData extends RuntimeException {
    public WrongData(String message) {
        super(message);
    }
}
