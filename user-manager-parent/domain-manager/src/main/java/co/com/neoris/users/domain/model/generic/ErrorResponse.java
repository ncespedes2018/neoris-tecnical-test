package co.com.neoris.users.domain.model.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Date;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonProperty("status_code")
    private String statusCode;
    private String message;
    private String description;
    @JsonProperty("date_time")
    private OffsetDateTime dateTime;
    @JsonProperty("error_code")
    private String error_code;
}
