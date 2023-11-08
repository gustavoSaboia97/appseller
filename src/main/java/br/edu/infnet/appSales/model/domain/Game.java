package br.edu.infnet.appSales.model.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TB_GAME")
public class Game extends Product {
    private String platformName;
    private String studioName;
}
