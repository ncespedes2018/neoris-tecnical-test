package co.com.neoris.accounts;

import co.com.neoris.accounts.domain.exceptions.accounts.AccountNotFoundException;
import co.com.neoris.accounts.domain.gateway.IAccountGateway;
import co.com.neoris.accounts.domain.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
@Slf4j
class AccountAdapterTest {

    @Autowired
    IAccountGateway gateway;


    @Test
    @Order(2)
    void getAccountByAccountNumberTest() throws AccountNotFoundException {
        Account account = getAccountEntityToTest();
        gateway.create(account);
        Account accountReturned = gateway.findAccountByAccountNumber(account.getAccountNumber());
        Assertions.assertNotNull(accountReturned);
        Assertions.assertEquals(accountReturned.getAccountNumber(),account.getAccountNumber());
        gateway.deleteAll();
    }

    @Test
    @Order(2)
    public void getAccountByClientIdNumberTest() throws AccountNotFoundException {
        Account account = getAccountEntityToTest();
        gateway.create(account);
        Account accountReturned = gateway.findAccountByClientIdNumber(account.getClientIdNumber());
        Assertions.assertNotNull(accountReturned);
        Assertions.assertEquals(accountReturned.getClientIdNumber(),account.getClientIdNumber());
        gateway.deleteAll();
    }


        @Test
        @Order(4)
        public void existsAccountByClientIdNumber() {
            Account account = getAccountEntityToTest();
            gateway.create(account);
            Assertions.assertTrue(gateway.existsAccountByClientIdNumber(account.getClientIdNumber()));
            gateway.deleteAll();
        }

    @Test
    @Order(4)
    public void existsAccountByAccountNumber() {
        Account account = getAccountEntityToTest();
        gateway.create(account);
        Assertions.assertTrue(gateway.existsAccountByAccountNumber(account.getAccountNumber()));
    }

    private Account getAccountEntityToTest(){
        Account account = new Account();
        account.setId(1L);
        account.setClientIdNumber("1973546");
        account.setAccountNumber("9425464");
        account.setAccountType("Ahorros");
        account.setInitialBalance(12002.29);
        account.setPassword("5678");
        account.setStatus(true);
        return account;
    }

}
