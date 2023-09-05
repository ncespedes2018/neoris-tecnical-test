package co.com.neoris.usecase;

import co.com.neoris.users.domain.exceptions.users.UserAlreadyExistException;
import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import co.com.neoris.users.domain.gateway.IClientGateway;
import co.com.neoris.users.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientUseCase {

    private final IClientGateway clientGateway;


    public Client getClientsByIdNumber(String idNumber) throws UserNotFoundException {
        return clientGateway.findClientByClientIdNumber(idNumber);
    }

    public Client getClientByFullName(String fullName) throws UserNotFoundException{
        return clientGateway.findClientByClientFullName(fullName);

    }

    public Client getClientById(Long id) throws UserNotFoundException{
        return clientGateway.findClientById(id);

    }

    public void creatClient(Client client) throws UserAlreadyExistException {
        if(clientGateway.existsClientByFullName(client.getFullName())){
            throw new UserAlreadyExistException();
        }
        clientGateway.create(client);
    }

    public void updateClient(Client client, String idNumber) throws UserNotFoundException {
        if(clientGateway.existsClientByIdNumber(idNumber)){
            throw new UserNotFoundException();
        }
        clientGateway.update(client, idNumber);
    }
}
