package co.com.neoris.api;

import co.com.neoris.exceptions.GlobalExceptionHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public abstract class ControllerCommonTest extends CommonTest {
    protected MockMvc mockMvc;

    protected <T> void initMockMvc(T apiImpl) {
        mockMvc = MockMvcBuilders.standaloneSetup(apiImpl)
                .setControllerAdvice(new GlobalExceptionHandler())
                .setMessageConverters(new MappingJackson2HttpMessageConverter(buildObjectMapper()), new StringHttpMessageConverter())
                .build();
    }

    protected void assertErrorResponse(String errorMessage, ResultActions resultActions) throws Exception {
        resultActions.andExpect(status().is5xxServerError())
                .andExpect(result -> assertEquals(errorMessage, Objects.requireNonNull(result.getResolvedException())
                        .getMessage()))
                .andExpect(jsonPath("$.code", Matchers.is(HttpStatus.INTERNAL_SERVER_ERROR.value())))
                .andExpect(jsonPath("$.message", Matchers.equalTo(errorMessage)))
                .andDo(mvcResult -> log.info(mvcResult.getResponse().getContentAsString()));
    }

    private ObjectMapper buildObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
}
