package co.com.neoris.users.repositories;

import co.com.neoris.users.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long>, JpaSpecificationExecutor<ClientEntity> {
    Optional<ClientEntity> findClientByPerson_IdNumber(String idNumber);

    Optional<ClientEntity> findClientByPerson_FullName(String fullName);

    Boolean existsClientEntityByPerson_FullName(String fullName);

    Boolean existsClientEntityByPerson_IdNumber(String idNumber);

}
