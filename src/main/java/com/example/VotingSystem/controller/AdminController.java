package com.example.VotingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.VotingSystem.model.User;
import com.example.VotingSystem.service.UserService;

@Controller
@RequestMapping("/admin")
@Lazy
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "admin-index";
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable("id") String id, Model model) {
        User user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "admin-user-details";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        User createdUser = userService.createUser(user);
        // todo: Add any necessary logic after user creation
        return "redirect:/admin/users/" + createdUser.getId();
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") String id, @ModelAttribute User user) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            // todo: Add any necessary logic after user update
            return "redirect:/admin/users/" + updatedUser.getId();
        } else {
            return "not-found";
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            userService.deleteUser(id);
            // todo: Add any necessary logic after user deletion
            return "redirect:/admin/users";
        } else {
            return "not-found";
        }
    }

}