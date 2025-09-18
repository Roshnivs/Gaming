package com.souparnikar.gameclub.modal;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String memberId;
    private String gameId;
    private Double amount;
    private Date dateTime;

    // Getters and setters
}