package com.juaracoding.oop;

import java.lang.reflect.Constructor;

public class UserAccount {

    // 1. Instance Variables (State)
    String username;
    String email;
    String role;
    boolean isActive;
    
    // 2. Default Constructor (Tanpa Parameter)
    public UserAccount() {
    this.role = "STANDARD_USER";
    this.isActive = true;
    }

    // 3. Parameterized Constructor (Constructor Overloading)
    public UserAccount(String username, String email, String role) {
    this.username = username; // this.username merujuk ke field class
    this.email = email;
    this.role = role;
    this.isActive = true;
    }
    // 4. Instance Method (Behavior)
    public void printAccountInfo() {
        System.out.println("User: " + this.username + " | Role: " + this.role + " | Active: " + this.isActive);
    }

}
