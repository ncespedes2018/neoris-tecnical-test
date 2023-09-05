package co.com.neoris.feignclient.internal.mappers;

import co.com.neoris.feignclient.internal.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IClientConverter {

    IClientConverter INSTANCE = Mappers.getMapper(IClientConverter.class);

    co.com.neoris.accounts.domain.model.Client fromDtoToModel(ClientDto clientDto);

}
