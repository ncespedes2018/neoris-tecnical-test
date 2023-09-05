package co.com.neoris.api;


import co.com.neoris.usecase.ClientUseCase;
import co.com.neoris.users.domain.exceptions.users.UserAlreadyExistException;
import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import co.com.neoris.users.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase useCase;

    @GetMapping("/id-number/{idNumber}")
    public ResponseEntity<?> getClientsByIdNumber(@PathVariable String idNumber) throws UserNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getClientsByIdNumber(idNumber));
    }

    @GetMapping("/full-name/{fullName}")
    public ResponseEntity<?> getClientsByFullName(@PathVariable String fullName) throws UserNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getClientsByIdNumber(fullName));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getClientsById(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getClientById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createClient(@RequestBody Client client) throws UserAlreadyExistException {
        useCase.creatClient(client);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/id-number/{idNumber}")
    public ResponseEntity<?> updateClient(@RequestBody Client client,
                                          @PathVariable String idNumber) throws UserNotFoundException {
        useCase.updateClient(client, idNumber);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
