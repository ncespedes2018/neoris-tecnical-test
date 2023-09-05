package co.com.neoris.users.domain.exceptions.users;

import co.com.neoris.users.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GenericException {
    public UserNotFoundException() {
        super("USER_ER_002","User does not exist", HttpStatus.CONFLICT);
    }
}
