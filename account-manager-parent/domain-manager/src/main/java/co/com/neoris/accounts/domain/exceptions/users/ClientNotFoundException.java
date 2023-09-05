package co.com.neoris.accounts.domain.exceptions.users;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends GenericException {
    public ClientNotFoundException() {
        super("ER-006","Account does not exist", HttpStatus.CONFLICT);
    }
}
