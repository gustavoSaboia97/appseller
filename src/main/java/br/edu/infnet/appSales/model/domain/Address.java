package br.edu.infnet.appSales.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Pattern(regexp = "\\d{5}-\\d{3}")
    @Column(unique = true)
    @JsonProperty("cep")
    private String zipCode;
    @JsonProperty("logradouro")
    private String street;
    @JsonProperty("bairro")
    private String neighborhood;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("localidade")
    private String local;
    @JsonProperty("uf")
    private String stateCode;
}
