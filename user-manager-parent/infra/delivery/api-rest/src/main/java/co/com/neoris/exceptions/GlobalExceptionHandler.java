package co.com.neoris.exceptions;


import co.com.neoris.users.domain.exceptions.users.UserAlreadyExistException;
import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ExceptionResponseBuilder {

    /**
     * Users Error Handlers
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> clientNotFoundExceptionHandler(UserNotFoundException e){
        return buildResponseEntity(e);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<?> clientNotFoundExceptionHandler(UserAlreadyExistException e){
        return buildResponseEntity(e);
    }

}
