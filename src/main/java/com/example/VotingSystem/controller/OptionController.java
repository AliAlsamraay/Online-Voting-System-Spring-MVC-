package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.VotingSystem.model.Option;
import com.example.VotingSystem.service.OptionService;

@Controller
@RequestMapping("/options")
public class OptionController {
    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/{id}")
    public String getOptionById(@PathVariable("id") String id, Model model) {
        Option option = optionService.getOptionById(id);
        if (option != null) {
            model.addAttribute("option", option);
            return "option-details";
        } else {
            return "not-found";
        }
    }

    @PostMapping
    public String createOption(@ModelAttribute Option option) {
        Option createdOption = optionService.createOption(option);
        //todo: Add any necessary logic after option creation
        return "redirect:/options/" + createdOption.getId();
    }

    @PutMapping("/{id}")
    public String updateOption(@PathVariable("id") String id, @ModelAttribute Option option) {
        Option existingOption = optionService.getOptionById(id);
        if (existingOption != null) {
            option.setId(id);
            Option updatedOption = optionService.updateOption(option);
           //todo:Add any necessary logic after option update
            return "redirect:/options/" + updatedOption.getId();
        } else {
            return "not-found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOption(@PathVariable("id") String id) {
        Option existingOption = optionService.getOptionById(id);
        if (existingOption != null) {
            optionService.deleteOption(id);
            //todo: Add any necessary logic after option deletion
            return "redirect:/options";
        } else {
            return "not-found";
        }
    }

}
