//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ecomsait.model;

public class Product {
    private int id;
    private String name;
    private String category;
    private Double price;
    private String image;

    public Product() {
    }

    public Product(int id, String name, String category, Double price, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString() {
        return "Product [id=" + this.id + ", name=" + this.name + ", category=" + this.category + ", price=" + this.price + ", image=" + this.image + "]";
    }
}
