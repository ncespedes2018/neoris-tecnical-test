package co.com.neoris.users.mappers;

import co.com.neoris.users.domain.model.Client;
import co.com.neoris.users.entities.ClientEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface IClientConverter {

    IClientConverter INSTANCE = Mappers.getMapper(IClientConverter.class);

    @Mapping(source = "person.fullName", target = "fullName",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person.gender", target = "gender",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person.age", target = "age",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person.idNumber", target = "idNumber",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person.address", target = "address",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "person.phone", target = "phone",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    co.com.neoris.users.domain.model.Client fromEntityToModel(ClientEntity ClientEntity);

    @Mapping(source = "client.password", target = "password",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.status", target = "status",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.fullName", target = "person.fullName",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.gender", target = "person.gender",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.age", target = "person.age",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.idNumber", target = "person.idNumber",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.address", target = "person.address",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "client.phone", target = "person.phone",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClientEntity fromModelToEntity(Client client);

    @Mapping(target = "id", ignore = true)
    ClientEntity fromModelToEntity(@MappingTarget ClientEntity entity , Client client);

}
