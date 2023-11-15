package br.edu.infnet.appSales.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesInfo {
    private Long totalOfSellers;
    private Long totalOfProducts;
    private Long totalOfGames;
    private Long totalOfBooks;
}
