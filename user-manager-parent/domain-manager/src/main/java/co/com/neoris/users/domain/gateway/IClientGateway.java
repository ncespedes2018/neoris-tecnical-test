package co.com.neoris.users.domain.gateway;

import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import co.com.neoris.users.domain.model.Client;

public interface IClientGateway {

    Client findClientByClientIdNumber(String idNumber) throws UserNotFoundException;

    Client findClientByClientFullName(String fullName) throws UserNotFoundException;

    Client findClientById(Long id) throws UserNotFoundException;

    void create(Client client);

    Boolean existsClientByFullName(String fullName);

    Boolean existsClientByIdNumber(String fullName);

    void deleteAll();

    void update(Client client, String idNumber);
}
