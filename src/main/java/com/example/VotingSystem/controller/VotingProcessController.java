package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.VotingSystem.model.VotingProcess;
import com.example.VotingSystem.service.VotingProcessService;

@Controller
@RequestMapping("/voting-processes")
public class VotingProcessController {
    private final VotingProcessService votingProcessService;

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(
            Model theModel) {
        // create model attribute to bind form data
        VotingProcess theVotingProcess = new VotingProcess();
        theModel.addAttribute("votingProcess", theVotingProcess);
        return "voteProcess/create";
    }

    @Autowired
    public VotingProcessController(VotingProcessService votingProcessService) {
        this.votingProcessService = votingProcessService;
    }

    @GetMapping("/{id}")
    public String getVotingProcessById(@PathVariable("id") String id, Model model) {
        VotingProcess votingProcess = votingProcessService.getVotingProcessById(id);
        if (votingProcess != null) {
            model.addAttribute("votingProcess", votingProcess);
            return "voting-process-details";
        } else {
            return "not-found";
        }
    }

    @PostMapping
    public String createVotingProcess(@ModelAttribute VotingProcess votingProcess) {
        VotingProcess createdVotingProcess = votingProcessService.createVotingProcess(votingProcess);
        // todo: Add any necessary logic after voting process creation
        return "redirect:/voting-processes/" + createdVotingProcess.getId();
    }

    @PutMapping("/{id}")
    public String updateVotingProcess(@PathVariable("id") String id, @ModelAttribute VotingProcess votingProcess) {
        VotingProcess existingVotingProcess = votingProcessService.getVotingProcessById(id);
        if (existingVotingProcess != null) {
            votingProcess.setId(id);
            VotingProcess updatedVotingProcess = votingProcessService.updateVotingProcess(votingProcess);
            // todo:Add any necessary logic after voting process update
            return "redirect:/voting-processes/" + updatedVotingProcess.getId();
        } else {
            return "not-found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteVotingProcess(@PathVariable("id") String id) {
        VotingProcess existingVotingProcess = votingProcessService.getVotingProcessById(id);
        if (existingVotingProcess != null) {
            votingProcessService.deleteVotingProcess(id);
            // todo: Add any necessary logic after voting process deletion
            return "redirect:/voting-processes";
        } else {
            return "not-found";
        }
    }
}