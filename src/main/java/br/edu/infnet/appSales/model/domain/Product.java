package br.edu.infnet.appSales.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TB_PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Size(min = 10, max = 50)
    private String title;
    @NotNull
    @Size(min = 10, max = 100)
    private String description;
    @Positive
    private BigDecimal price;
    @PositiveOrZero
    private Integer quantity;
    private ProductType type;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
