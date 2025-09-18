package com.souparnikar.gameclub.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Document(collection = "recharges")
public class Recharge {

    @Id
    private String id;

    @DBRef
    private Member member; // Assuming you have a Member class

    private Double amount;

    private Date dateTime = new Date(); // Defaults to now

    // Getters and Setters
    public String getId() { return id; }

    public Member getMember() { return member; }

    public void setMember(Member member) { this.member = member; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public Date getDateTime() { return dateTime; }

    public void setDateTime(Date dateTime) { this.dateTime = dateTime; }
}