package co.com.neoris.users;

import co.com.neoris.users.domain.exceptions.users.UserNotFoundException;
import co.com.neoris.users.domain.gateway.IClientGateway;
import co.com.neoris.users.domain.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
@Slf4j
class ClientAdapterTest {

    @Autowired
    IClientGateway gateway;


    @Test
    @Order(2)
    void getClientByClientIdNumberTest() throws UserNotFoundException {
        Client client = getClientEntityToTest();
        gateway.create(client);
        Client clientReturned = gateway.findClientByClientIdNumber(client.getIdNumber());
        Assertions.assertNotNull(clientReturned);
        Assertions.assertEquals(clientReturned.getIdNumber(),client.getIdNumber());
        gateway.deleteAll();
    }

    @Test
    @Order(2)
    public void getClientByClientFullNameTest() throws UserNotFoundException {
        Client client = getClientEntityToTest();
        gateway.create(client);
        Client clientReturned = gateway.findClientByClientFullName(client.getFullName());
        Assertions.assertNotNull(clientReturned);
        Assertions.assertEquals(clientReturned.getFullName(),client.getFullName());
        gateway.deleteAll();
    }


        @Test
        @Order(4)
        public void existsClientByFullNameTest() {
            Client client = getClientEntityToTest();
            gateway.create(client);
            Assertions.assertTrue(gateway.existsClientByFullName(client.getFullName()));
        }

    private Client getClientEntityToTest(){
        Client client = new Client();
        client.setId(1L);
        client.setIdNumber("1973546");
        client.setFullName("Marianela Montalvo");
        client.setGender("F");
        client.setAddress("Amazonas y NNUU");
        client.setPhone("097548965");
        client.setPassword("5678");
        client.setStatus(true);
        return client;
    }

}
