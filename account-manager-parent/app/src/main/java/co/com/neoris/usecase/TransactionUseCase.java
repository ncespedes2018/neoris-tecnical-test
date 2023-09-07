package co.com.neoris.usecase;

import co.com.neoris.accounts.domain.TranactionTypeEnum;
import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionAlreadyExistException;
import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.gateway.IAccountGateway;
import co.com.neoris.accounts.domain.gateway.IClientGateway;
import co.com.neoris.accounts.domain.gateway.ITransactionGateway;
import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Transaction;
import co.com.neoris.accounts.entities.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionUseCase {

    private final ITransactionGateway transactionGateway;
    private final IClientGateway clientGateway;
    private final IAccountGateway accountGateway;

    public List<Transaction> getTransactionsByClientId(String clientIdNumber) throws TransactionNotFoundException {
        return transactionGateway.findTransactionByClientIdNumber(clientIdNumber);
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) throws TransactionNotFoundException {
        return transactionGateway.findTransactionByAccountNumber(accountNumber);

    }

    public Transaction getTransactionById(Long id) throws TransactionNotFoundException {
        return transactionGateway.findTransactionById(id);

    }

    public void createTransaction(Transaction transaction) throws ClientNotFoundException, AccountNotFoundException, TransactionNotFoundException, TransactionAlreadyExistException {
        if (transactionGateway.findTransactionByTransactionDate(transaction.getTransactionDate())){
            throw new TransactionAlreadyExistException();
        }
        clientGateway.findClientByIdNumber(transaction.getClientIdNumber());
        Account account = accountGateway.findAccountByAccountNumber(transaction.getAccountNumber());
        List<Transaction> transactions = transactionGateway
                .findTransactionByAccountNumber(transaction.getAccountNumber());

        Double actualBalance=0.0;

        if(transactions.isEmpty()){
            actualBalance = account.getInitialBalance();
        }else {
            Transaction transaction1 = transactionGateway
                    .findTransactionByTransactiomDateMax(transaction.getAccountNumber());
            actualBalance = transaction1.getBalance();
        }
        if(transaction.getTransactionType().equals(TranactionTypeEnum.CREDITO)) {
            transaction.setValue(transaction.getValue()*-1);
        }
        transaction.setBalance(actualBalance + transaction.getValue());
        transactionGateway.create(transaction, account);
    }

    public void updateTransaction(Transaction transaction, Long id)
            throws TransactionNotFoundException, ClientNotFoundException {
        if(!transactionGateway.existById(id)){
            throw new TransactionNotFoundException();
        }
        if (transaction.getClientIdNumber() != null && !transaction.getClientIdNumber().isEmpty()){
            clientGateway.findClientByIdNumber(transaction.getClientIdNumber());
        }
        transactionGateway.update(transaction, id);
    }
}
