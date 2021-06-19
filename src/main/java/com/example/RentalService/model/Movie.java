package com.example.RentalService.model;


import com.example.RentalService.model.enums.CategoryMovie;

public class Movie {


    private Integer id;
    private String name;

    private Boolean isAvailable = false;

    private CategoryMovie category;

    public Movie(int id, String name, CategoryMovie category, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isAvailable = isAvailable;
    }
    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryMovie getCategory() {
        return category;
    }

    public void setCategory(CategoryMovie category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
