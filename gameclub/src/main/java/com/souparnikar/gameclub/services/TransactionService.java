package com.souparnikar.gameclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souparnikar.gameclub.exceptions.IdNotPresentException;
import com.souparnikar.gameclub.modal.Transaction;
import com.souparnikar.gameclub.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repo;

    public Transaction create(Transaction transaction) {
        transaction.setId(null); // Ensure new entry
        Transaction savedTransaction = repo.save(transaction);
        return savedTransaction;
    }

    public List<Transaction> findAll() {
        return repo.findAll();
    }

    public Transaction findById(String id) throws IdNotPresentException {
        Optional<Transaction> optionalTransaction = repo.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new IdNotPresentException("Transaction not found: " + id);
        }
        return optionalTransaction.get();
    }

    public Transaction update(String id, Transaction transaction) throws IdNotPresentException {
        Optional<Transaction> optionalTransaction = repo.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new IdNotPresentException("Transaction not found: " + id);
        }
        Transaction oldTransaction = optionalTransaction.get();
        oldTransaction.setAmount(transaction.getAmount());
        oldTransaction.setType(transaction.getType());
        oldTransaction.setDate(transaction.getDate());
        return repo.save(oldTransaction);
    }

    public boolean delete(String id) throws IdNotPresentException {
        Optional<Transaction> optionalTransaction = repo.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new IdNotPresentException("Transaction not found: " + id);
        }
        repo.deleteById(id);
        return true;
    }
}