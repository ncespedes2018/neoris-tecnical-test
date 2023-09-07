package co.com.neoris.api;


import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.model.Transaction;
import co.com.neoris.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionUseCase useCase;

    @GetMapping("/client-id-number/{clientIdNumber}")
    public ResponseEntity<?> getAccountsByClientIdNumber(@PathVariable String clientIdNumber) throws TransactionNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getTransactionsByClientId(clientIdNumber));
    }

    @GetMapping("/account-number/{accountNumber}")
    public ResponseEntity<?> getAccountsByAccountNumber(@PathVariable String accountNumber) throws TransactionNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getTransactionsByAccountNumber(accountNumber));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAccountsById(@PathVariable Long id) throws TransactionNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(useCase.getTransactionById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createAccount(@RequestBody Transaction transaction)
            throws ClientNotFoundException, AccountNotFoundException, TransactionNotFoundException, TransactionAlreadyExistException {
        useCase.createTransaction(transaction);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateAccount(@RequestBody Transaction transaction,
                                          @PathVariable Long id)
            throws ClientNotFoundException, TransactionNotFoundException {

        useCase.updateTransaction(transaction, id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
