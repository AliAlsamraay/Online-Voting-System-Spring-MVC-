package com.example.VotingSystem.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CachingAspect {

    @Cacheable(value = "votingProcesses")
    @Before("execution(* com.example.VotingSystem.service.VotingProcessService.getVotingProcess(..))")
    public void cacheVotingProcess() {
        // acts as an advice for caching the voting process
    }

    @CacheEvict(value = "votingProcesses", allEntries = true)
    @Before("execution(* com.example.VotingSystem.service.VotingProcessService.createVotingProcess(..)) || " +
            "execution(* com.example.VotingSystem.service.VotingProcessService.updateVotingProcess(..)) || " +
            "execution(* com.example.VotingSystem.service.VotingProcessService.deleteVotingProcess(..))")
    public void evictVotingProcessCache() {
        // acts as an advice for evicting the voting process cache
    }
}
