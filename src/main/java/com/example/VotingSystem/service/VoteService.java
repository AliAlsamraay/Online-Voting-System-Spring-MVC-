package com.example.VotingSystem.service;

import com.example.VotingSystem.model.Vote;

public interface VoteService {
    Vote getVoteById(String id);

    Vote createVote(Vote vote);

    Vote updateVote(Vote vote);

    void deleteVote(String id);
}