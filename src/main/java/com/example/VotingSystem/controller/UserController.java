package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.VotingSystem.model.User;
import com.example.VotingSystem.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "user-details";
        } else {
            return "not-found";
        }
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        User createdUser = userService.createUser(user);
        // todo: Add any necessary logic after user creation
        return "redirect:/users/" + createdUser.getId();
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") String id, @ModelAttribute User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            // todo: Add any necessary logic after user update
            return "redirect:/users/" + updatedUser.getId();
        } else {
            return "not-found";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            userService.deleteUser(id);
            // todo: Add any necessary logic after user deletion
            return "redirect:/users";
        } else {
            return "not-found";
        }
    }

}