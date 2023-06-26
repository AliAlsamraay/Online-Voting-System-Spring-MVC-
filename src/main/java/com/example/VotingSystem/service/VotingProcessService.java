package com.example.VotingSystem.service;

import java.util.List;

import com.example.VotingSystem.model.VotingProcess;

public interface VotingProcessService {
    VotingProcess getVotingProcessById(String id);

    List<VotingProcess> getAllVotingProcesses();

    VotingProcess createVotingProcess(VotingProcess votingProcess);

    VotingProcess updateVotingProcess(VotingProcess votingProcess);

    void deleteVotingProcess(String id);

}