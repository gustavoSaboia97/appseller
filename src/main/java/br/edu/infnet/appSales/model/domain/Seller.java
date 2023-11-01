package br.edu.infnet.appSales.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_SELLER")
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
    @OneToMany
    @JoinColumn(name = "seller_id")
    private List<Product> products;

    private Seller(SellerBuilder builder){
        this.id = builder.id;
        this.cpf = builder.cpf;
        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.isActive = builder.isActive;
        this.products = builder.products;
    }

    public Seller() {}

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isActive() {
        return isActive;
    }


    public List<Product> getProducts(){
        return products;
    }

    @Override
    public String toString(){
        return "[SELLER]\n" +
            "ID: " + this.getId() + "\n" +
           "CPF: " + this.getCpf() + "\n" +
           "Name: " + this.getName() + "\n" +
           "Nickname: " + this.getNickname() + "\n" +
           "Email: " + this.getEmail() + "\n" +
           "Is Active: " + this.isActive() + "\n" +
           "--------------------";
    }

    public static class SellerBuilder {
        private Integer id;
        private String cpf;
        private String name;
        private String email;
        private String nickname;
        private boolean isActive;

        private List<Product> products;

        public SellerBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public SellerBuilder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public SellerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public SellerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public SellerBuilder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public SellerBuilder setActive(boolean active) {
            this.isActive = active;
            return this;
        }

        public SellerBuilder setProducts(List<Product> products) {
            this.products = products;
            return this;
        }

        public SellerBuilder setProducts() {
            this.products = new ArrayList<>();
            return this;
        }

        public Seller build(){
            return new Seller(this);
        }
    }
}
