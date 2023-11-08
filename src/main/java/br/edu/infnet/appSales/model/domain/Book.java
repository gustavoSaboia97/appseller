package br.edu.infnet.appSales.model.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "TB_BOOK")
public class Book extends Product {
    private String authorName;
    private String publisherName;
    private Integer numberOfPages;
}
