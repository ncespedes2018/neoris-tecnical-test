package co.com.neoris.exceptions;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ExceptionResponseBuilder {

    /**
     * Account Errors Handlers
     */
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> accountNotFoundExceptionHandler(AccountNotFoundException e){
        return buildResponseEntity(e);
    }

    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<?> accountAlreadyExistExceptionHandler(AccountAlreadyExistException e){
        return buildResponseEntity(e);
    }

    /**
     * Transaction Errors Handlers
     */
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<?> transactionNotFoundExceptionHandler(TransactionNotFoundException e){
        return buildResponseEntity(e);
    }

    @ExceptionHandler(TransactionAlreadyExistException.class)
    public ResponseEntity<?> transactionNotFoundExceptionHandler(TransactionAlreadyExistException e){
        return buildResponseEntity(e);
    }
    /**
     * Users Error Handlers
     */
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> clientNotFoundExceptionHandler(ClientNotFoundException e){
        return buildResponseEntity(e);
    }


}
