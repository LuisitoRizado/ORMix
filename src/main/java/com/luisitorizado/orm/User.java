package com.luisitorizado.orm;

import com.luisitorizado.annotations.Column;
import com.luisitorizado.annotations.Entity;
import com.luisitorizado.annotations.Id;
import com.luisitorizado.annotations.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
}
