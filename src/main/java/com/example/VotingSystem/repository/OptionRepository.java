package com.example.VotingSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.VotingSystem.model.Option;

@Repository
public interface OptionRepository extends MongoRepository<Option, String> {
}
