package co.com.neoris.api;

import co.com.neoris.usecase.AccountUseCase;
import co.com.neoris.accounts.domain.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Slf4j
class AccountControllerTest extends ControllerCommonTest {


    @MockBean
    private AccountUseCase useCase;

    private Account account;

    @BeforeEach
    void setUp() {
        final AccountController accountController = new AccountController(useCase);
        initMockMvc(accountController);
        account = jsonToObject("json/account.json", Account.class);
    }

    @Test
    void getAccountsByClientIdNumber() throws Exception {
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        Mockito.when(useCase.getAccountsByClientIdNumber(any(String.class))).thenReturn(accounts);

        mockMvc.perform(get("/accounts/client-id-number/197538246"))
                .andExpect(status().isOk())
                .andDo(mvcResult -> log.info(mvcResult.getResponse().getContentAsString()));
    }


}