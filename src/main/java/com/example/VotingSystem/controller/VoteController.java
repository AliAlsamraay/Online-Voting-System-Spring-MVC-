package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.VotingSystem.model.Vote;
import com.example.VotingSystem.service.VoteService;

@Controller
@RequestMapping("/votes")
public class VoteController {
    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("/{id}")
    public String getVoteById(@PathVariable("id") String id, Model model) {
        Vote vote = voteService.getVoteById(id);
        if (vote != null) {
            model.addAttribute("vote", vote);
            return "vote-details";
        } else {
            return "not-found";
        }
    }

    @PostMapping("save")
    public String createVote(@ModelAttribute Vote vote) {
        Vote createdVote = voteService.createVote(vote);
        // todo: Add any necessary logic after vote creation
        return "redirect:/votes/" + createdVote.getId();
    }

    @PutMapping("/{id}")
    public String updateVote(@PathVariable("id") String id, @ModelAttribute Vote vote) {
        Vote existingVote = voteService.getVoteById(id);
        if (existingVote != null) {
            vote.setId(id);
            Vote updatedVote = voteService.updateVote(vote);
            // todo: Add any necessary logic after vote update
            return "redirect:/votes/" + updatedVote.getId();
        } else {
            return "not-found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteVote(@PathVariable("id") String id) {
        Vote existingVote = voteService.getVoteById(id);
        if (existingVote != null) {
            voteService.deleteVote(id);
            // todo: Add any necessary logic after vote deletion
            return "redirect:/votes";
        } else {
            return "not-found";
        }
    }
}