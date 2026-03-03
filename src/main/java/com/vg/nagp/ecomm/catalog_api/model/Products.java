package com.vg.nagp.ecomm.catalog_api.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "products")
public class Products {

    @Id
    private String id;

    private String name;
    private String description;
    private double price;
    private double originalPrice;
    private String category;
    private String image;
    private double rating;
    private int reviews;
    private boolean inStock;
    private String sellerId;

    // Constructors
    public Products() {
        this.id = UUID.randomUUID().toString();
    }

    public Products(String id, String name, String description, double price, double originalPrice,
                    String category, String image, double rating, int reviews, boolean inStock, String sellerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.originalPrice = originalPrice;
        this.category = category;
        this.image = image;
        this.rating = rating;
        this.reviews = reviews;
        this.inStock = inStock;
        this.sellerId = sellerId;
    }
    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    public boolean isInStock() {
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    public String getSellerId() {
        return sellerId;
    }
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", inStock=" + inStock +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
