package co.com.neoris.accounts.domain.exceptions.accounts;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistException extends GenericException {

    public AccountAlreadyExistException() {
        super("ER-001","Username already exist", HttpStatus.CONFLICT);
    }

}
