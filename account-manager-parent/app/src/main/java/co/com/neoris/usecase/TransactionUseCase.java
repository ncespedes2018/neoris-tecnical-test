package co.com.neoris.usecase;

import co.com.neoris.accounts.domain.exceptions.transactions.TransactionNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.gateway.IClientGateway;
import co.com.neoris.accounts.domain.gateway.ITransactionGateway;
import co.com.neoris.accounts.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionUseCase {

    private final ITransactionGateway transactionGateway;
    private final IClientGateway clientGateway;


    public List<Transaction> getTransactionsByClientId(String clientIdNumber) throws TransactionNotFoundException {
        return transactionGateway.findTransactionByClientIdNumber(clientIdNumber);
    }

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) throws TransactionNotFoundException {
        return transactionGateway.findTransactionByTransactionNumber(accountNumber);

    }

    public Transaction getTransactionById(Long id) throws TransactionNotFoundException {
        return transactionGateway.findTransactionById(id);

    }

    public void createTransaction(Transaction transaction) throws ClientNotFoundException {
        clientGateway.findClientByIdNumber(transaction.getClientIdNumber());
        transactionGateway.create(transaction);
    }

    public void updateTransaction(Transaction transaction, Long id)
            throws TransactionNotFoundException, ClientNotFoundException {
        if(transactionGateway.existById(id)){
            throw new TransactionNotFoundException();
        }
        if (transaction.getClientIdNumber() != null && !transaction.getClientIdNumber().isEmpty()){
            clientGateway.findClientByIdNumber(transaction.getClientIdNumber());
        }
        transactionGateway.update(transaction, id);
    }
}
