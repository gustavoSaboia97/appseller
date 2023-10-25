package br.edu.infnet.appSales.model.domain;

import jakarta.persistence.*;

@Entity
public class Book extends Product {
    private String authorName;
    private String publisherName;
    private Integer numberOfPages;

    Book(BookBuilder builder) {
        super(builder);

        this.authorName = builder.authorName;
        this.publisherName = builder.publisherName;
        this.numberOfPages = builder.numberOfPages;
    }

    public Book() {

    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return super.toString() +
           "Author Name: " + this.getAuthorName() + "\n" +
           "Publisher Name: " + this.getPublisherName() + "\n" +
           "Number of Pages: " + this.getNumberOfPages() + "\n" +
           "--------------------";
    }

    public static class BookBuilder extends ProductBuilder<BookBuilder> {
        private String authorName;
        private String publisherName;
        private Integer numberOfPages;

        public BookBuilder setAuthorName(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public BookBuilder setPublisherName(String publisherName) {
            this.publisherName = publisherName;
            return this;
        }

        public BookBuilder setNumberOfPages(Integer numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        @Override
        public Product build(){
            return new Book(this);
        }

        @Override
        protected BookBuilder self(){
            return this;
        }
    }
}
