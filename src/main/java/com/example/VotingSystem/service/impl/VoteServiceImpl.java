package com.example.VotingSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem.model.Vote;
import com.example.VotingSystem.repository.VoteRepository;
import com.example.VotingSystem.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public Vote getVoteById(String id) {
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public Vote createVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public Vote updateVote(Vote vote) {
        return voteRepository.save(vote);
    }

    @Override
    public void deleteVote(String id) {
        voteRepository.deleteById(id);
    }
    
    // Add additional methods as per your requirements
}