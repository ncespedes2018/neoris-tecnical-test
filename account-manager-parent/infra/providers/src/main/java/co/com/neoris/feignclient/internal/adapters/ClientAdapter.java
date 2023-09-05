package co.com.neoris.feignclient.internal.adapters;


import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.gateway.IClientGateway;
import co.com.neoris.accounts.domain.model.Client;
import co.com.neoris.feignclient.internal.client.ClientFeignClient;
import co.com.neoris.feignclient.internal.dto.ClientDto;
import co.com.neoris.feignclient.internal.mappers.IClientConverter;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientAdapter implements IClientGateway {

    Logger logger = LoggerFactory.getLogger(ClientAdapter.class);

    private final ClientFeignClient client;

    private final IClientConverter mapper;

    @Override
    public Client findClientByIdNumber(String idNumber) throws ClientNotFoundException {
        try{
            ResponseEntity<?> response = client.getClientByIdNumber(idNumber);
            logger.info("*** Client Find***");
            ClientDto clientReturned= (ClientDto) response.getBody();
            logger.info(response.toString());
            return mapper.fromDtoToModel(clientReturned);
        } catch (FeignException.FeignClientException e){
            throw new ClientNotFoundException();
        }
    }
}
