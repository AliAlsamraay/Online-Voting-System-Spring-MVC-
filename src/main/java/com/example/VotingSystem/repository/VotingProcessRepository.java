package com.example.VotingSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.model.VotingProcess;

@Repository
public interface VotingProcessRepository extends MongoRepository<VotingProcess, String> {

}
