package org.umar.learning.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Age must be positive")
    private int age;

    @NotBlank(message = "College is required")
    private String college;

    @NotBlank(message = "password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    //  Default constructor (required by JPA)
    public User() {
    }

    //  Parameterized constructor
    public User(long id, String name, int age, String college, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.college = college;
        this.password = password;
    }

    //  Getters and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
