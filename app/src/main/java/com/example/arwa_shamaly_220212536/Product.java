package com.example.arwa_shamaly_220212536;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    int id;
    String productName;
    int quantityAvailable;
    String hasToShow;

    public Product(String productName, int quantityAvailable, String hasToShow) {
        this.productName = productName;
        this.quantityAvailable = quantityAvailable;
        this.hasToShow = hasToShow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getHasToShow() {
        return hasToShow;
    }

    public void setHasToShow(String hasToShow) {
        this.hasToShow = hasToShow;
    }
}
