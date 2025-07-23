package org.umar.learning.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //optional : one category can have many inventory
    @OneToMany(mappedBy = "Category", cascade = CascadeType.ALL)
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
