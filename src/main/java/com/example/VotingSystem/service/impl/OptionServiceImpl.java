package com.example.VotingSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.VotingSystem.model.Option;
import com.example.VotingSystem.repository.OptionRepository;
import com.example.VotingSystem.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionRepository optionRepository;

    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public Option getOptionById(String id) {
        return optionRepository.findById(id).orElse(null);
    }

    @Override
    public Option createOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option updateOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public void deleteOption(String id) {
        optionRepository.deleteById(id);
    }

}
