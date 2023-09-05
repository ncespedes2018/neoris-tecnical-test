package co.com.neoris.accounts.repositories;

import co.com.neoris.accounts.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long>, JpaSpecificationExecutor<AccountEntity> {
    Optional<AccountEntity> findAccountEntityByClientIdNumber(String clientIdNumber);

    Optional<AccountEntity> findAccountEntityByAccountNumber(String accountNumber);

    Boolean existsAccountEntityByClientIdNumber(String accountNumber);

    Boolean existsAccountEntityByAccountNumber(String idNumber);

}
