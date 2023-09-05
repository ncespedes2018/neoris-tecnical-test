package co.com.neoris.accounts.domain.model.generic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Pagination {

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("page_size")
    public Integer size;

    @JsonProperty("total_elements")
    public Long totalElements;

    @JsonProperty("total_pages")
    public Integer totalPages;

}
