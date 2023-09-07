package co.com.neoris.accounts.adapters;


import co.com.neoris.accounts.domain.gateway.ITransactionGateway;
import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Transaction;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.TransactionEntity;
import co.com.neoris.accounts.mappers.IAccountConverter;
import co.com.neoris.accounts.mappers.ITransactionConverter;
import co.com.neoris.accounts.repositories.ITransactionRepository;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionAdapter implements ITransactionGateway {

    Logger logger = LoggerFactory.getLogger(TransactionAdapter.class);

    private final ITransactionRepository repository;
    private final ITransactionConverter converter;
    private final IAccountConverter accountConverter;

    @Override
    public List<Transaction> findTransactionByClientIdNumber(String clientNumber) {
        List<TransactionEntity> transactionEntities = repository
                .findTransactionEntitiesByClientIdNumber(clientNumber);
        List<Transaction> transactions = new ArrayList<>();
        if(transactionEntities.isEmpty()){
            return transactions;
        }

        for (TransactionEntity transactionEntity: transactionEntities) {
            transactions.add(converter.fromEntityToModel(transactionEntity));
        }
        return transactions;
    }

    @Override
    public List<Transaction> findTransactionByAccountNumber(String accountNumber) {
        List<TransactionEntity> transactionEntities = repository
                .findTransactionEntitiesByAccount_AccountNumber(accountNumber);
        List<Transaction> transactions = new ArrayList<>();
        if(transactionEntities.isEmpty()){
            return transactions;
        }

        for (TransactionEntity transactionEntity: transactionEntities) {
            transactions.add(converter.fromEntityToModel(transactionEntity));
        }
        return transactions;
    }

    @Override
    public Transaction findTransactionByTransactiomDateMax(String accountNumber) throws TransactionNotFoundException {
        List<TransactionEntity> transactionEntity = repository
                .findTransactionEntitiesByAccount_AccountNumber(accountNumber);

        return converter.fromEntityToModel(transactionEntity.stream()
                .max(Comparator.comparing(TransactionEntity::getTransactionDate)).
                orElseThrow(() -> new TransactionNotFoundException()));
    }

    @Override
    public Transaction findTransactionById(Long id) throws TransactionNotFoundException {
        TransactionEntity transactionEntity = repository
                .findById(id)
                .orElseThrow(TransactionNotFoundException::new);
        return converter.fromEntityToModel(transactionEntity);
    }

    @Override
    @Transactional
    public void create(Transaction transaction, Account account) {
        logger.info("♠------- Create New List<Transaction> --------♠");
        TransactionEntity transactionEntity = converter.fromModelToEntity(transaction);
        logger.info(transactionEntity.toString());
        OffsetDateTime now = OffsetDateTime.now();
        AccountEntity accountEntity = accountConverter.fromModelToEntity(account);
        transactionEntity.setAudCreatedAt(now);
        transactionEntity.setAudUpdatedAt(now);
        transactionEntity.setAccount(accountEntity);
        repository.save(transactionEntity);
    }

    @Override
    public Boolean findTransactionByTransactionDate(OffsetDateTime offsetDateTime){
        return repository.existsByTransactionDate(offsetDateTime);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(Transaction transaction, Long id) {
        logger.info("♠------- Update New List<Transaction> --------♠");
        TransactionEntity transactionEntity = converter
                .fromModelToEntity(repository.findById(id).get(),
                        transaction);

        logger.info(transactionEntity.toString());
        repository.save(transactionEntity);
    }


    @Override
    public Boolean existById(Long id){
        return repository.existsById(id);
    }
}
