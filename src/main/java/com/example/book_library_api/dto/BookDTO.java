package com.example.book_library_api.dto;

import jakarta.validation.constraints.*;

public class BookDTO {

    @NotBlank(message="Title is required")
    private String title;

    @NotBlank(message="Author is required")
    private String author;

    @NotBlank(message="Genre is required")
    private String genre;

    @Positive
    private double price;

    @Min(1500)
    private int publishedYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}