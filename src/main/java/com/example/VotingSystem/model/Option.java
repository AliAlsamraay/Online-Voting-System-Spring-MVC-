package com.example.VotingSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "options")
public class Option {
    @Id
    private String id;
    private String votingProcessId;
    private String title;

    // Constructors.
    public Option() {
    }

    public Option(String id, String votingProcessId, String title) {
        this.id = id;
        this.votingProcessId = votingProcessId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVotingProcessId() {
        return votingProcessId;
    }

    public void setVotingProcessId(String votingProcessId) {
        this.votingProcessId = votingProcessId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}