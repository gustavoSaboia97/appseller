package br.edu.infnet.appSales.model.domain;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String title;
    private String description;
    private BigDecimal price;
    private int quantity;

    Product(ProductBuilder<?> builder){
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.quantity = builder.quantity;
    }

    public int getId() {
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

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "[PRODUCT]\n" +
           "Title: " + this.getTitle() + "\n" +
           "Description: " + this.getDescription() + "\n" +
           "Price: " + this.getPrice() + "\n" +
           "Quantity: " + this.getQuantity() + "\n";
    }

    abstract static class ProductBuilder<T extends ProductBuilder> {
        private int id;
        private String title;
        private String description;
        private BigDecimal price;
        private int quantity;

        public T setId(int id){
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

        public T setQuantity(int quantity){
            this.quantity = quantity;
            return self();
        }

        public Product build(){
            return new Product(this);
        }

        abstract T self();
    }
}
