package co.com.neoris.accounts.domain.exceptions.transactions;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class TransactionNotFoundException extends GenericException {
    public TransactionNotFoundException() {
        super("TRANS_ER_001","Transaction does not exist", HttpStatus.CONFLICT);
    }
}
