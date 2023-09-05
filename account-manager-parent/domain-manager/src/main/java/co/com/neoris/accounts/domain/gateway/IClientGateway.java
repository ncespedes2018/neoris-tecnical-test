package co.com.neoris.accounts.domain.gateway;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.exceptions.users.ClientNotFoundException;
import co.com.neoris.accounts.domain.model.Account;
import co.com.neoris.accounts.domain.model.Client;

public interface IClientGateway {

    Client findClientByIdNumber(String idNumber) throws ClientNotFoundException;
}
