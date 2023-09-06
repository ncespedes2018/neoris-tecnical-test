package co.com.neoris.accounts.mappers;

import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Account.AccountBuilder;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.AccountEntity.AccountEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T17:55:31+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (OpenLogic)"
)
@Component
public class IAccountConverterImpl implements IAccountConverter {

    @Override
    public Account fromEntityToModel(AccountEntity accountEntity) {
        if ( accountEntity == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        if ( accountEntity.getClientIdNumber() != null ) {
            account.clientIdNumber( accountEntity.getClientIdNumber() );
        }
        if ( accountEntity.getPassword() != null ) {
            account.password( accountEntity.getPassword() );
        }
        if ( accountEntity.getAccountNumber() != null ) {
            account.accountNumber( accountEntity.getAccountNumber() );
        }
        if ( accountEntity.getAccountType() != null ) {
            account.accountType( accountEntity.getAccountType() );
        }
        if ( accountEntity.getInitialBalance() != null ) {
            account.initialBalance( accountEntity.getInitialBalance() );
        }
        if ( accountEntity.getStatus() != null ) {
            account.status( accountEntity.getStatus() );
        }
        if ( accountEntity.getAudCreatedAt() != null ) {
            account.audCreatedAt( accountEntity.getAudCreatedAt() );
        }
        if ( accountEntity.getAudUpdatedAt() != null ) {
            account.audUpdatedAt( accountEntity.getAudUpdatedAt() );
        }

        return account.build();
    }

    @Override
    public AccountEntity fromModelToEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntityBuilder accountEntity = AccountEntity.builder();

        if ( account.getClientIdNumber() != null ) {
            accountEntity.clientIdNumber( account.getClientIdNumber() );
        }
        if ( account.getPassword() != null ) {
            accountEntity.password( account.getPassword() );
        }
        if ( account.getAccountNumber() != null ) {
            accountEntity.accountNumber( account.getAccountNumber() );
        }
        if ( account.getAccountType() != null ) {
            accountEntity.accountType( account.getAccountType() );
        }
        if ( account.getInitialBalance() != null ) {
            accountEntity.initialBalance( account.getInitialBalance() );
        }
        if ( account.getStatus() != null ) {
            accountEntity.status( account.getStatus() );
        }
        if ( account.getAudCreatedAt() != null ) {
            accountEntity.audCreatedAt( account.getAudCreatedAt() );
        }
        if ( account.getAudUpdatedAt() != null ) {
            accountEntity.audUpdatedAt( account.getAudUpdatedAt() );
        }

        return accountEntity.build();
    }

    @Override
    public AccountEntity fromModelToEntity(AccountEntity entity, Account account) {
        if ( account == null ) {
            return null;
        }

        if ( account.getClientIdNumber() != null ) {
            entity.setClientIdNumber( account.getClientIdNumber() );
        }
        if ( account.getPassword() != null ) {
            entity.setPassword( account.getPassword() );
        }
        if ( account.getAccountNumber() != null ) {
            entity.setAccountNumber( account.getAccountNumber() );
        }
        if ( account.getAccountType() != null ) {
            entity.setAccountType( account.getAccountType() );
        }
        if ( account.getInitialBalance() != null ) {
            entity.setInitialBalance( account.getInitialBalance() );
        }
        if ( account.getStatus() != null ) {
            entity.setStatus( account.getStatus() );
        }
        if ( account.getAudCreatedAt() != null ) {
            entity.setAudCreatedAt( account.getAudCreatedAt() );
        }
        if ( account.getAudUpdatedAt() != null ) {
            entity.setAudUpdatedAt( account.getAudUpdatedAt() );
        }

        return entity;
    }
}
