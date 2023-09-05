package co.com.neoris.usecase;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.gateway.IAccountGateway;
import co.com.neoris.accounts.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountUseCase {

    private final IAccountGateway accountGateway;


    public Account getAccountsByClientIdNumber(String clientIdNumber) throws AccountNotFoundException {
        return accountGateway.findAccountByClientIdNumber(clientIdNumber);
    }

    public Account getAccountByAccountNumber(String fullName) throws AccountNotFoundException {
        return accountGateway.findAccountByAccountNumber(fullName);

    }

    public Account getAccountById(Long id) throws AccountNotFoundException {
        return accountGateway.findAccountById(id);

    }

    public void creatAccount(Account account) throws AccountAlreadyExistException {
        if(accountGateway.existsAccountByClientIdNumber(account.getClientIdNumber())){
            throw new AccountAlreadyExistException();
        }
        accountGateway.create(account);
    }

    public void updateAccount(Account account, String accountNumber) throws AccountNotFoundException {
        if(accountGateway.existsAccountByAccountNumber(accountNumber)){
            throw new AccountNotFoundException();
        }
        accountGateway.update(account, accountNumber);
    }
}
