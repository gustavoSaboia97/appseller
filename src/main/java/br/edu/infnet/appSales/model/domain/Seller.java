package br.edu.infnet.appSales.model.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_SELLER")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
    private String cpf;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @Size(min = 2, max = 10)
    private String nickname;
    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean isActive;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
