package com.souparnikar.gameclub.controller;

import com.souparnikar.gameclub.modal.Member;
import com.souparnikar.gameclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/members")
public class MemberController {

    @Autowired
    private MemberRepository repo;

    @PostMapping
    public Member create(@RequestBody Member member) {
        member.setId(null); // let MongoDB generate ObjectId
        if (member.getBalance() == null) {
            member.setBalance(0.0); // default value
        }
        return repo.save(member);
    }

    @GetMapping
    public List<Member> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable String id, @RequestBody Member member) {
        return repo.findById(id).map(old -> {
            old.setName(member.getName());
            old.setBalance(member.getBalance() != null ? member.getBalance() : old.getBalance());
            old.setPhone(member.getPhone());
            return repo.save(old);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }
}