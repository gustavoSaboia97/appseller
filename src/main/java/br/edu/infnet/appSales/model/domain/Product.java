package br.edu.infnet.appSales.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

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

    Product(ProductBuilder<?> builder){
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.type = builder.type;
        this.seller = builder.seller;
    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ProductType getType() {
        return type;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "[PRODUCT]\n" +
           "Title: " + this.getTitle() + "\n" +
           "Description: " + this.getDescription() + "\n" +
           "Price: " + this.getPrice() + "\n" +
           "Quantity: " + this.getQuantity() + "\n" +
           "Type: " + this.getType() + "\n";
    }

    abstract static class ProductBuilder<T extends ProductBuilder> {
        private Integer id;
        private String title;
        private String description;
        private BigDecimal price;
        private Integer quantity;
        private ProductType type;
        private Seller seller;

        public T setId(Integer id){
            this.id = id;
            return self();
        }

        public T setTitle(String title){
            this.title = title;
            return self();
        }

        public T setDescription(String description){
            this.description = description;
            return self();
        }

        public T setPrice(BigDecimal price){
            this.price = price;
            return self();
        }

        public T setQuantity(Integer quantity){
            this.quantity = quantity;
            return self();
        }

        public T setType(ProductType type){
            this.type = type;
            return self();
        }

        public T setSeller(Seller seller){
            this.seller = seller;
            return self();
        }

        public Product build(){
            return new Product(this);
        }

        abstract T self();
    }
}
