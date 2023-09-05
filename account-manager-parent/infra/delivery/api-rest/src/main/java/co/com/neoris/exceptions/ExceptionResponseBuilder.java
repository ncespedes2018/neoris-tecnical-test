package co.com.neoris.exceptions;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import co.com.neoris.accounts.domain.model.generic.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

public class ExceptionResponseBuilder {
    public ResponseEntity<?> buildResponseEntity(GenericException e){
        HttpStatus statusCode = e.getStatusCode();
        OffsetDateTime now = OffsetDateTime.now();
        return  ResponseEntity
                .status(statusCode)
                .body(ErrorResponse.builder()
                        .dateTime(now)
                        .error_code(e.getCode())
                        .statusCode(String.valueOf(statusCode.value()))
                        .message(e.getDescription())
                        .build());
    }
}
