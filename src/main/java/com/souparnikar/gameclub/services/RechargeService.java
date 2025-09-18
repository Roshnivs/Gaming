package com.souparnikar.gameclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souparnikar.gameclub.exceptions.IdNotPresentException;
import com.souparnikar.gameclub.modal.Recharge;
import com.souparnikar.gameclub.repository.RechargeRepository;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository repo;

    public Recharge create(Recharge recharge) {
        recharge.setId(null); // Ensure new entry
        Recharge savedRecharge = repo.save(recharge);
        return savedRecharge;
    }

    public List<Recharge> findAll() {
        List<Recharge> recharges = repo.findAll();
        return recharges;
    }

    public Recharge findById(String id) throws IdNotPresentException {
        Optional<Recharge> optionalRecharge = repo.findById(id);
        if (optionalRecharge.isEmpty()) {
            throw new IdNotPresentException("Recharge not found: " + id);
        }
        return optionalRecharge.get();
    }

    public Recharge update(String id, Recharge recharge) throws IdNotPresentException {
        Optional<Recharge> optionalRecharge = repo.findById(id);
        if (optionalRecharge.isEmpty()) {
            throw new IdNotPresentException("Recharge not found: " + id);
        }
        Recharge oldRecharge = optionalRecharge.get();
        oldRecharge.setAmount(recharge.getAmount());
        oldRecharge.setMember(recharge.getMember());
        oldRecharge.setDateTime(recharge.getDateTime());

        Recharge updatedRecharge = repo.save(oldRecharge);
        return updatedRecharge;
    }

    public boolean delete(String id) throws IdNotPresentException {
        Optional<Recharge> optionalRecharge = repo.findById(id);
        if (optionalRecharge.isEmpty()) {
            throw new IdNotPresentException("Recharge not found: " + id);
        }
        repo.deleteById(id);
        return true;
    }
}