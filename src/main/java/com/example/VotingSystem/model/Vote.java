package com.example.VotingSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votes")
public class Vote {
    @Id
    private String id;
    private String userId;
    private String votingProcessId;
    private String optionId;

    // Constructors.
    public Vote() {
    }

    public Vote(String userId, String votingProcessId, String optionId) {
        this.userId = userId;
        this.votingProcessId = votingProcessId;
        this.optionId = optionId;
    }

    // Getters and setters.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public String getVotingProcessId() {
        return votingProcessId;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVotingProcessId(String votingProcessId) {
        this.votingProcessId = votingProcessId;
    }

    // toString() method
    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", votingProcessId='" + votingProcessId + '\'' +
                ", optionId='" + optionId + '\'' +
                '}';
    }
}