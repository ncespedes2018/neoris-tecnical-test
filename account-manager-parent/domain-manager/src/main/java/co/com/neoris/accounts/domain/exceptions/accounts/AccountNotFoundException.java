package co.com.neoris.accounts.domain.exceptions.accounts;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends GenericException {
    public AccountNotFoundException() {
        super("ACCOUNT_ER_001","Account does not exist", HttpStatus.CONFLICT);
    }
}
