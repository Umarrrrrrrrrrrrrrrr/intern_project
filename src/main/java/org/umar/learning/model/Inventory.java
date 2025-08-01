package org.umar.learning.model;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String itemName;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //getter and setter method
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
}
