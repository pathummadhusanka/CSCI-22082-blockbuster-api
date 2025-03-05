package com.example.demo.models;

public class Movie {
    private Long id;

    public Movie(String title, int releaseYear, boolean available, MovieGenre genre) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.available = available;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    private String title;
    private int releaseYear;
    private boolean available;
    private MovieGenre genre; // Enum (MovieGenre)
}
