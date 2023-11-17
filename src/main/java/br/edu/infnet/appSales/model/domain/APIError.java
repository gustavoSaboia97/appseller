package br.edu.infnet.appSales.model.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class APIError {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
    private Integer statusCode;
}
