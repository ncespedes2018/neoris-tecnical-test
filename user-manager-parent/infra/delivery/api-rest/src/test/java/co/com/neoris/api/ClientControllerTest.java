package co.com.neoris.api;

import co.com.neoris.usecase.ClientUseCase;
import co.com.neoris.users.domain.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Slf4j
class ClientControllerTest extends ControllerCommonTest {


    @MockBean
    private ClientUseCase useCase;

    private Client client;

    @BeforeEach
    void setUp() {
        final ClientController clientController = new ClientController(useCase);
        initMockMvc(clientController);
        client = jsonToObject("json/client.json", Client.class);
    }

    @Test
    void getclient() throws Exception {
        Mockito.when(useCase.getClientsByIdNumber(any(String.class))).thenReturn(client);

        mockMvc.perform(get("/clients/id-number/197538246"))
                .andExpect(status().isOk())
                .andDo(mvcResult -> log.info(mvcResult.getResponse().getContentAsString()));
    }


}