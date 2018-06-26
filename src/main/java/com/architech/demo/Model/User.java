package com.architech.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    public String username;

    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
