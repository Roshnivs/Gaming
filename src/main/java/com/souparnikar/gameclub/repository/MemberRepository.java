package com.souparnikar.gameclub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.souparnikar.gameclub.modal.Member;

import java.util.Optional;

public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByPhone(String phone);
}