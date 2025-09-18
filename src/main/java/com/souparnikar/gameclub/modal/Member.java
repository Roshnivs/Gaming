package com.souparnikar.gameclub.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
public class Member {

    @Id
    private String id;

    private String name;

    private Double balance = 0.0;

    @Indexed(unique = true)
    private String phone;

    // --- Constructors ---
    public Member() {}

    public Member(String name, Double balance, String phone) {
        this.name = name;
        this.balance = balance;
        this.phone = phone;
    }

    // --- Getters & Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}