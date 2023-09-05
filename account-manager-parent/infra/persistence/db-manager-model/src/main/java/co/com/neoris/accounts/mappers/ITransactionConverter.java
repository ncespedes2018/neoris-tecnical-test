package co.com.neoris.accounts.mappers;

import co.com.neoris.accounts.domain.model.Client;
import co.com.neoris.accounts.domain.model.Transaction;
import co.com.neoris.accounts.entities.AccountEntity;
import co.com.neoris.accounts.entities.TransactionEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITransactionConverter {

    ITransactionConverter INSTANCE = Mappers.getMapper(ITransactionConverter.class);

    @Mapping(source = "account.clientIdNumber", target = "accountNumber",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction fromEntityToModel(TransactionEntity transaction);

    @Mapping(source = "client.idNumber", target = "clientIdNumber",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Transaction fromClientToTransaction(@MappingTarget Transaction transaction, Client client);

    TransactionEntity fromModelToEntity(co.com.neoris.accounts.domain.model.Transaction transaction);

    TransactionEntity fromModelToEntity(@MappingTarget TransactionEntity entity , co.com.neoris.accounts.domain.model.Transaction transaction);

}
