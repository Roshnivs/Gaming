package com.souparnikar.gameclub.controller;

import com.souparnikar.gameclub.exceptions.IdNotPresentException;
import com.souparnikar.gameclub.modal.Recharge;
import com.souparnikar.gameclub.services.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/recharges")
public class RechargeController {

    @Autowired
    private RechargeService service;

    @PostMapping
    public ResponseEntity<Recharge> create(@RequestBody Recharge recharge){
        Recharge savedRecharge = service.create(recharge);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecharge);
    }

    @GetMapping
    public ResponseEntity<List<Recharge>> findAll() {
        List<Recharge> recharges = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recharges);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Recharge> findById(@PathVariable String id) throws IdNotPresentException {
        Recharge recharge = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(recharge);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Recharge> update(@PathVariable String id, @RequestBody Recharge recharge) throws IdNotPresentException {
        Recharge updatedRecharge = service.update(id, recharge);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRecharge);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws IdNotPresentException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}