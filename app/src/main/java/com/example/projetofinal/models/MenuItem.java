package com.example.projetofinal.models;

public class MenuItem {
    private String name;
    private String category;
    private String size;
    private double price;

    // Construtor com quatro parâmetros
    public MenuItem(String name, String category, String size, double price) {
        this.name = name;
        this.category = category;
        this.size = size;
        this.price = price;
    }

    // Construtor com dois parâmetros
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
