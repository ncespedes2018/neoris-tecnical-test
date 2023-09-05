package co.com.neoris.users.adapters;

import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import co.com.neoris.users.entities.ClientEntity;
import co.com.neoris.users.mappers.IClientConverter;
import co.com.neoris.users.repositories.IClientRepository;
import co.com.neoris.users.domain.gateway.IClientGateway;
import co.com.neoris.users.domain.model.Client;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAdapter implements IClientGateway {

    Logger logger = LoggerFactory.getLogger(ClientAdapter.class);

    private final IClientRepository repository;
    private final IClientConverter converter;

    @Override
    public Client findClientByClientIdNumber(String idNumber) throws UserNotFoundException {
        ClientEntity clientEntity = repository
                .findClientByPerson_IdNumber(idNumber)
                .orElseThrow(UserNotFoundException::new);
        return converter.fromEntityToModel(clientEntity);
    }

    @Override
    public Client findClientByClientFullName(String fullName) throws UserNotFoundException {
        ClientEntity clientEntity = repository
                .findClientByPerson_FullName(fullName)
                .orElseThrow(UserNotFoundException::new);
        return converter.fromEntityToModel(clientEntity);    }

    @Override
    public Client findClientById(Long id) throws UserNotFoundException {
        ClientEntity clientEntity = repository
                .findById(id)
                .orElseThrow(UserNotFoundException::new);
        return converter.fromEntityToModel(clientEntity);    }

    @Override
    public void create(Client client) {
        logger.info("♠------- Create New Client --------♠");
        ClientEntity clientEntity = converter.fromModelToEntity(client);
        logger.info(clientEntity.toString());
        repository.save(clientEntity);
    }

    @Override
    public Boolean existsClientByFullName(String fullName) {
        return repository.existsClientEntityByPerson_FullName(fullName);
    }

    @Override
    public Boolean existsClientByIdNumber(String idNumber) {
        return repository.existsClientEntityByPerson_IdNumber(idNumber);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void update(Client client, String idNumber) {
        logger.info("♠------- Create New Client --------♠");
        ClientEntity clientEntity = converter
                .fromModelToEntity(repository.findClientByPerson_IdNumber(idNumber).get(),
                        client);

        logger.info(clientEntity.toString());
        repository.save(clientEntity);
    }
}
