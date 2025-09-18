package com.souparnikar.gameclub.repository;

import com.souparnikar.gameclub.modal.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RechargeRepository extends MongoRepository<Recharge, String> {
    // Add custom queries if needed
}