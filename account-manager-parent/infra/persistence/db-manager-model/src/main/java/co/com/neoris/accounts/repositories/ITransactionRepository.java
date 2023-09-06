package co.com.neoris.accounts.repositories;

import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, Long>, JpaSpecificationExecutor<TransactionEntity> {
    List<TransactionEntity> findTransactionEntitiesByClientIdNumber(String clientIdNumber);

    List<TransactionEntity> findTransactionEntitiesByAccount_AccountNumber(String accountNumber);

    TransactionEntity findByTransactionDateMax();

}
