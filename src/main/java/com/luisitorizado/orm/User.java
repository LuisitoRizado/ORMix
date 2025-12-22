package com.luisitorizado.orm;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Entity;
import com.luisitorizado.annotations.Id;
import com.luisitorizado.annotations.Table;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Getters and setters
    public long getId() {
        return this.id;
    }

    public void setId(long newId) {
        this.id = newId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
}
