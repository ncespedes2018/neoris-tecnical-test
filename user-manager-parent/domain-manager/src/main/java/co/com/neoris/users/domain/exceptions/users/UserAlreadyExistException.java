package co.com.neoris.users.domain.exceptions.users;

import co.com.neoris.users.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends GenericException {

    public UserAlreadyExistException() {
        super("ER-001","Username already exist", HttpStatus.CONFLICT);
    }

}
