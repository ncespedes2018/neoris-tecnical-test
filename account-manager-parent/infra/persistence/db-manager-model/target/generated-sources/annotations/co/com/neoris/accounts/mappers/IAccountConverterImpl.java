package co.com.neoris.accounts.mappers;

import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Account.AccountBuilder;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.AccountEntity.AccountEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-05T13:13:40+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (OpenLogic)"
)
@Component
public class IAccountConverterImpl implements IAccountConverter {

    @Override
    public Account fromEntityToModel(AccountEntity AccountEntity) {
        if ( AccountEntity == null ) {
            return null;
        }

        AccountBuilder account = Account.builder();

        if ( AccountEntity.getId() != null ) {
            account.id( AccountEntity.getId() );
        }
        if ( AccountEntity.getClientIdNumber() != null ) {
            account.clientIdNumber( AccountEntity.getClientIdNumber() );
        }
        if ( AccountEntity.getPassword() != null ) {
            account.password( AccountEntity.getPassword() );
        }
        if ( AccountEntity.getAccountNumber() != null ) {
            account.accountNumber( AccountEntity.getAccountNumber() );
        }
        if ( AccountEntity.getAccountType() != null ) {
            account.accountType( AccountEntity.getAccountType() );
        }
        if ( AccountEntity.getInitialBalance() != null ) {
            account.initialBalance( AccountEntity.getInitialBalance() );
        }
        if ( AccountEntity.getStatus() != null ) {
            account.status( AccountEntity.getStatus() );
        }
        if ( AccountEntity.getAudCreatedAt() != null ) {
            account.audCreatedAt( AccountEntity.getAudCreatedAt() );
        }
        if ( AccountEntity.getAudUpdatedAt() != null ) {
            account.audUpdatedAt( AccountEntity.getAudUpdatedAt() );
        }

        return account.build();
    }

    @Override
    public AccountEntity fromModelToEntity(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountEntityBuilder accountEntity = AccountEntity.builder();

        if ( account.getId() != null ) {
            accountEntity.id( account.getId() );
        }
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

        if ( account.getId() != null ) {
            entity.setId( account.getId() );
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
