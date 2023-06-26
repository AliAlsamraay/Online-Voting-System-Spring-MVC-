package com.example.VotingSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voters")
public class Voter {
    @Id
    private String id;
    private String userId;
    private String votingProcessId;

    // Constructors.
    public Voter() {
    }

    public Voter(String id, String userId, String votingProcessId) {
        this.id = id;
        this.userId = userId;
        this.votingProcessId = votingProcessId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVotingProcessId() {
        return votingProcessId;
    }

    public void setVotingProcessId(String votingProcessId) {
        this.votingProcessId = votingProcessId;
    }

}
