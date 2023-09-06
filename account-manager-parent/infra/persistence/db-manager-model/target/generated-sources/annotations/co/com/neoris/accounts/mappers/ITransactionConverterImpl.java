package co.com.neoris.accounts.mappers;

import co.com.neoris.accounts.domain.model.Client;
import co.com.neoris.accounts.domain.model.Transaction;
import co.com.neoris.accounts.domain.model.Transaction.TransactionBuilder;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.TransactionEntity;
import co.com.neoris.accounts.entities.TransactionEntity.TransactionEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T16:30:08+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (OpenLogic)"
)
@Component
public class ITransactionConverterImpl implements ITransactionConverter {

    @Override
    public Transaction fromEntityToModel(TransactionEntity transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionBuilder transaction1 = Transaction.builder();

        String clientIdNumber = transactionAccountClientIdNumber( transaction );
        if ( clientIdNumber != null ) {
            transaction1.accountNumber( clientIdNumber );
        }
        if ( transaction.getId() != null ) {
            transaction1.id( transaction.getId() );
        }
        if ( transaction.getTransactionDate() != null ) {
            transaction1.transactionDate( transaction.getTransactionDate() );
        }
        if ( transaction.getTransactionType() != null ) {
            transaction1.transactionType( transaction.getTransactionType() );
        }
        if ( transaction.getValue() != null ) {
            transaction1.value( transaction.getValue() );
        }
        if ( transaction.getBalance() != null ) {
            transaction1.balance( transaction.getBalance() );
        }
        if ( transaction.getAudCreatedAt() != null ) {
            transaction1.audCreatedAt( transaction.getAudCreatedAt() );
        }
        if ( transaction.getAudUpdatedAt() != null ) {
            transaction1.audUpdatedAt( transaction.getAudUpdatedAt() );
        }
        if ( transaction.getClientIdNumber() != null ) {
            transaction1.clientIdNumber( transaction.getClientIdNumber() );
        }

        return transaction1.build();
    }

    @Override
    public Transaction fromClientToTransaction(Transaction transaction, Client client) {
        if ( client == null ) {
            return null;
        }

        if ( client.getIdNumber() != null ) {
            transaction.setClientIdNumber( client.getIdNumber() );
        }
        if ( client.getId() != null ) {
            transaction.setId( client.getId() );
        }

        return transaction;
    }

    @Override
    public TransactionEntity fromModelToEntity(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionEntityBuilder transactionEntity = TransactionEntity.builder();

        if ( transaction.getId() != null ) {
            transactionEntity.id( transaction.getId() );
        }
        if ( transaction.getTransactionDate() != null ) {
            transactionEntity.transactionDate( transaction.getTransactionDate() );
        }
        if ( transaction.getClientIdNumber() != null ) {
            transactionEntity.clientIdNumber( transaction.getClientIdNumber() );
        }
        if ( transaction.getTransactionType() != null ) {
            transactionEntity.transactionType( transaction.getTransactionType() );
        }
        if ( transaction.getValue() != null ) {
            transactionEntity.value( transaction.getValue() );
        }
        if ( transaction.getBalance() != null ) {
            transactionEntity.balance( transaction.getBalance() );
        }
        if ( transaction.getAudCreatedAt() != null ) {
            transactionEntity.audCreatedAt( transaction.getAudCreatedAt() );
        }
        if ( transaction.getAudUpdatedAt() != null ) {
            transactionEntity.audUpdatedAt( transaction.getAudUpdatedAt() );
        }

        return transactionEntity.build();
    }

    @Override
    public TransactionEntity fromModelToEntity(TransactionEntity entity, Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        if ( transaction.getId() != null ) {
            entity.setId( transaction.getId() );
        }
        if ( transaction.getTransactionDate() != null ) {
            entity.setTransactionDate( transaction.getTransactionDate() );
        }
        if ( transaction.getClientIdNumber() != null ) {
            entity.setClientIdNumber( transaction.getClientIdNumber() );
        }
        if ( transaction.getTransactionType() != null ) {
            entity.setTransactionType( transaction.getTransactionType() );
        }
        if ( transaction.getValue() != null ) {
            entity.setValue( transaction.getValue() );
        }
        if ( transaction.getBalance() != null ) {
            entity.setBalance( transaction.getBalance() );
        }
        if ( transaction.getAudCreatedAt() != null ) {
            entity.setAudCreatedAt( transaction.getAudCreatedAt() );
        }
        if ( transaction.getAudUpdatedAt() != null ) {
            entity.setAudUpdatedAt( transaction.getAudUpdatedAt() );
        }

        return entity;
    }

    private String transactionAccountClientIdNumber(TransactionEntity transactionEntity) {
        if ( transactionEntity == null ) {
            return null;
        }
        AccountEntity account = transactionEntity.getAccount();
        if ( account == null ) {
            return null;
        }
        String clientIdNumber = account.getClientIdNumber();
        if ( clientIdNumber == null ) {
            return null;
        }
        return clientIdNumber;
    }
}
