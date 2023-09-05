package co.com.neoris.feignclient.internal.client;

import co.com.neoris.feignclient.internal.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Feign client to connect with topology manager
 */
@FeignClient(name = "clients", url = "${openfeign.basePath.client-url}")
public interface ClientFeignClient {

    /**
     * Method for getting transit time from topology service manager
     *
     * @param idNumber version identifier
     * @return The matrix response
     */
    @GetMapping(value = "/clients/id-number/{idNumber}", headers = {"Content-Type=application-json"})
    ResponseEntity<ClientDto> getClientByIdNumber(@PathVariable(value = "idNumber") String idNumber);


}