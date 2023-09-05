package co.com.neoris.accounts.adapters;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.mappers.IAccountConverter;
import co.com.neoris.accounts.repositories.IAccountRepository;
import co.com.neoris.accounts.domain.gateway.IAccountGateway;
import co.com.neoris.accounts.domain.model.Account;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAdapter implements IAccountGateway {

    Logger logger = LoggerFactory.getLogger(AccountAdapter.class);

    private final IAccountRepository repository;
    private final IAccountConverter converter;

    @Override
    public Account findAccountByClientIdNumber(String clientNumber) throws AccountNotFoundException {
        AccountEntity accountEntity = repository
                .findAccountEntityByClientIdNumber(clientNumber)
                .orElseThrow(AccountNotFoundException::new);
        return converter.fromEntityToModel(accountEntity);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) throws AccountNotFoundException {
        AccountEntity accountEntity = repository
                .findAccountEntityByAccountNumber(accountNumber)
                .orElseThrow(AccountNotFoundException::new);
        return converter.fromEntityToModel(accountEntity);    }

    @Override
    public Account findAccountById(Long id) throws AccountNotFoundException {
        AccountEntity accountEntity = repository
                .findById(id)
                .orElseThrow(AccountNotFoundException::new);
        return converter.fromEntityToModel(accountEntity);    }

    @Override
    public void create(Account account) {
        logger.info("♠------- Create New Account --------♠");
        AccountEntity accountEntity = converter.fromModelToEntity(account);
        logger.info(accountEntity.toString());
        repository.save(accountEntity);
    }

    @Override
    public Boolean existsAccountByClientIdNumber(String clientNumber) {
        return repository.existsAccountEntityByClientIdNumber(clientNumber);
    }

    @Override
    public Boolean existsAccountByAccountNumber(String accountNumber) {
        return repository.existsAccountEntityByAccountNumber(accountNumber);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(Account account, String accountNumber) {
        logger.info("♠------- Update New Account --------♠");
        AccountEntity accountEntity = converter
                .fromModelToEntity(repository.findAccountEntityByAccountNumber(accountNumber).get(),
                        account);

        logger.info(accountEntity.toString());
        repository.save(accountEntity);
    }
}
