package com.example.VotingSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem.model.VotingProcess;
import com.example.VotingSystem.repository.VotingProcessRepository;
import com.example.VotingSystem.service.VotingProcessService;

@Service
public class VotingProcessServiceImpl implements VotingProcessService {
    private final VotingProcessRepository votingProcessRepository;

    @Autowired
    public VotingProcessServiceImpl(VotingProcessRepository votingProcessRepository) {
        this.votingProcessRepository = votingProcessRepository;
    }

    @Override
    public VotingProcess getVotingProcessById(String id) {
        return votingProcessRepository.findById(id).orElse(null);
    }

    @Override
    public List<VotingProcess> getAllVotingProcesses() {
        return votingProcessRepository.findAll();
    }

    @Override
    public VotingProcess createVotingProcess(VotingProcess votingProcess) {
        return votingProcessRepository.save(votingProcess);
    }

    @Override
    public VotingProcess updateVotingProcess(VotingProcess votingProcess) {
        return votingProcessRepository.save(votingProcess);
    }

    @Override
    public void deleteVotingProcess(String id) {
        votingProcessRepository.deleteById(id);
    }

}