package com.example.VotingSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.model.Vote;

@Repository
public interface VoteRepository extends MongoRepository<Vote, String> {

}
