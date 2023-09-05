package co.com.neoris.feignclient.internal.mappers;

import co.com.neoris.accounts.domain.model.Client;
import co.com.neoris.accounts.domain.model.Client.ClientBuilder;
import co.com.neoris.feignclient.internal.dto.ClientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-06T01:35:23+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class IClientConverterImpl implements IClientConverter {

    @Override
    public Client fromDtoToModel(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        ClientBuilder client = Client.builder();

        return client.build();
    }
}
