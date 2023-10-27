package br.edu.infnet.appSales.model.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_GAME")
public class Game extends Product {
    private String platformName;
    private String studioName;

    protected Game(GameBuilder builder){
        super(builder);

        this.platformName = builder.platformName;
        this.studioName = builder.studioName;
    }

    public Game() {

    }

    public String getPlatformName() {
        return platformName;
    }

    public String getStudioName() {
        return studioName;
    }

    @Override
    public String toString() {
        return super.toString() +
            "Platform Name: " + this.getPlatformName() + "\n" +
            "Studio Name: " + this.getStudioName() + "\n" +
            "--------------------";
    }

    public static class GameBuilder extends ProductBuilder<GameBuilder> {
        private String platformName;
        private String studioName;

        public GameBuilder setPlatformName(String platformName) {
            this.platformName = platformName;
            return this;
        }

        public GameBuilder setStudioName(String studioName) {
            this.studioName = studioName;
            return this;
        }

        @Override
        public Product build(){
            return new Game(this);
        }

        @Override
        protected GameBuilder self(){
            return this;
        }
    }
}
