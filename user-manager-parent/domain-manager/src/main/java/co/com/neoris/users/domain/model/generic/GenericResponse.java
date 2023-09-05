package co.com.neoris.users.domain.model.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    @JsonProperty("data")
    Object body;
    Pagination metadata;
}
