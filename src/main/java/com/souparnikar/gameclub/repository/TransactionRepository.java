package com.souparnikar.gameclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.souparnikar.gameclub.modal.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}