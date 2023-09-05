package co.com.neoris.accounts.domain.exceptions.users;

import co.com.neoris.accounts.domain.exceptions.generic.GenericException;
import org.springframework.http.HttpStatus;

public class ClientNotFoundException extends GenericException {
    public ClientNotFoundException() {
        super("CLIENT_ER_001","Client does not exist", HttpStatus.CONFLICT);
    }
}
