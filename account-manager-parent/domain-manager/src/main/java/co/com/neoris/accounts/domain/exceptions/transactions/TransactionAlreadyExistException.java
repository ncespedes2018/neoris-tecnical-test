package co.com.neoris.accounts.domain.exceptions.transactions;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class TransactionAlreadyExistException extends GenericException {
    public TransactionAlreadyExistException() {
        super("TRANS_ER_002","Transaction already exist, please valid transaction date", HttpStatus.BAD_REQUEST);
    }
}
