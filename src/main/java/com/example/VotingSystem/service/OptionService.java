package com.example.VotingSystem.service;

import com.example.VotingSystem.model.Option;

public interface OptionService {
    Option getOptionById(String id);

    Option createOption(Option option);

    Option updateOption(Option option);

    void deleteOption(String id);

}