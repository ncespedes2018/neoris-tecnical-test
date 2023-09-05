package co.com.neoris.usecase;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.gateway.IAccountGateway;
import co.com.neoris.accounts.domain.gateway.IClientGateway;
import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountUseCase {

    private final IAccountGateway accountGateway;
    private final IClientGateway clientGateway;


    public List<Account> getAccountsByClientIdNumber(String clientIdNumber) throws AccountNotFoundException {
        return accountGateway.findAccountByClientIdNumber(clientIdNumber);
    }

    public Account getAccountByAccountNumber(String fullName) throws AccountNotFoundException {
        return accountGateway.findAccountByAccountNumber(fullName);

    }

    public Account getAccountById(Long id) throws AccountNotFoundException {
        return accountGateway.findAccountById(id);

    }

    public void creatAccount(Account account)
            throws AccountAlreadyExistException, ClientNotFoundException {
        if(accountGateway.existsAccountByAccountNumber(account.getAccountNumber())){
            throw new AccountAlreadyExistException();
        }
        clientGateway.findClientByIdNumber(account.getClientIdNumber());
        accountGateway.create(account);
    }

    public void updateAccount(Account account, String accountNumber)
            throws AccountNotFoundException, ClientNotFoundException {
        if(accountGateway.existsAccountByAccountNumber(accountNumber)){
            throw new AccountNotFoundException();
        }
        if (account.getClientIdNumber() != null && !account.getClientIdNumber().isEmpty()){
            clientGateway.findClientByIdNumber(account.getClientIdNumber());
        }
        accountGateway.update(account, accountNumber);
    }
}
