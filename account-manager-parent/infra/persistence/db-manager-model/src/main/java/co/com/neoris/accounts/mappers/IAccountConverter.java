package co.com.neoris.accounts.mappers;

import co.com.neoris.accounts.entities.AccountEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IAccountConverter {

    IAccountConverter INSTANCE = Mappers.getMapper(IAccountConverter.class);

    co.com.neoris.accounts.domain.model.Account fromEntityToModel(AccountEntity accountEntity);

    AccountEntity fromModelToEntity(co.com.neoris.accounts.domain.model.Account account);

     AccountEntity fromModelToEntity(@MappingTarget AccountEntity entity , co.com.neoris.accounts.domain.model.Account account);

}
