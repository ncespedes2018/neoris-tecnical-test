package co.com.neoris.feignclient.internal.client;

import co.com.neoris.feignclient.internal.dto.ClientDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign client to connect with topology manager
 */
@FeignClient(name = "clients", url = "${client-url}")
public interface ClientFeignClient {

    /**
     * Method for getting transit time from topology service manager
     *
     * @param versionId version identifier
     * @return The matrix response
     */
    @GetMapping(value = "/id-number/{idNumber}", headers = {"Content-Type=application-json"})
    ResponseEntity<ClientDto> getClientByIdNumber(@PathVariable(value = "idNumber") String idNumber);


}