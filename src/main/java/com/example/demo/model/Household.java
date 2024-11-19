package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name = "household")

public class Household extends Product {

    @Column(name = "brand")
    private String brand;

    @Column(name = "origin")
    private String origin;

    @Column(name = "material")
    private String material;

    // Constructors
    public Household() {
    }

    public Household(String name, double price, int quantity, String brand, String origin, String material) {
        super(name, price, quantity);
        this.brand = brand;
        this.origin = origin;
        this.material = material;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

