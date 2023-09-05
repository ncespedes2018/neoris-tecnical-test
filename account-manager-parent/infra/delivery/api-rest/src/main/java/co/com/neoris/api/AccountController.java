package co.com.neoris.api;


import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.usecase.AccountUseCase;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountUseCase useCase;

    @GetMapping("/client-id-number/{clientIdNumber}")
    public ResponseEntity<?> getAccountsByClientIdNumber(@PathVariable String clientIdNumber) throws AccountNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getAccountsByClientIdNumber(clientIdNumber));
    }

    @GetMapping("/account-number/{accountNumber}")
    public ResponseEntity<?> getAccountsByAccountNumber(@PathVariable String accountNumber) throws AccountNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getAccountByAccountNumber(accountNumber));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAccountsById(@PathVariable Long id) throws AccountNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getAccountById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createAccount(@RequestBody Account account) throws AccountAlreadyExistException,
            ClientNotFoundException {
        useCase.creatAccount(account);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/id-number/{idNumber}")
    public ResponseEntity<?> updateAccount(@RequestBody Account account,
                                          @PathVariable String accountNumber)
                                                throws AccountNotFoundException, ClientNotFoundException {
        useCase.updateAccount(account, accountNumber);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
