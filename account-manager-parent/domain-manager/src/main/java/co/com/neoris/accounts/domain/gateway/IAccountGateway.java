package co.com.neoris.accounts.domain.gateway;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.model.Account;

import java.util.List;

public interface IAccountGateway {

    List<Account> findAccountByClientIdNumber(String idNumber) throws AccountNotFoundException;

    Account findAccountByAccountNumber(String fullName) throws AccountNotFoundException;

    Account findAccountById(Long id) throws AccountNotFoundException;

    void create(Account account);

    Boolean existsAccountByClientIdNumber(String fullName);

    Boolean existsAccountByAccountNumber(String fullName);

    void deleteAll();

    void update(Account account, String idNumber);
}
