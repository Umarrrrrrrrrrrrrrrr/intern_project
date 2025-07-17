package org.umar.learning.model;

import jakarta.persistence.*;
import java.util.List;

public class Category {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //optional : one category can have many inventory
    @OneToMany(mappedBy = "Category", cascade = CascadeType.All)
    private List<Inventory> inventories;

    public Category(long id, String name) {}
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }



}
