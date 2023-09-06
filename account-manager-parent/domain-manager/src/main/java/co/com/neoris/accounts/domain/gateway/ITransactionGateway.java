package co.com.neoris.accounts.domain.gateway;

import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import co.com.neoris.accounts.domain.model.Transaction;

import java.util.List;

public interface ITransactionGateway {
    List<Transaction> findTransactionByClientIdNumber(String clientNumber);

    List<Transaction> findTransactionByAccountNumber(String accountNumber);

    Transaction findTransactionByTransactiomDateMax();

    Transaction findTransactionById(Long id) throws TransactionNotFoundException;

    void create(Transaction transaction);

    void deleteAll();

    void update(Transaction transaction, Long id);

    Boolean existById(Long id);
}
