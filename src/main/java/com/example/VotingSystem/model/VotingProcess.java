package com.example.VotingSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "votingProcesses")
public class VotingProcess {
    @Id
    private String id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;

    // Constructors, getters, and setters
    public VotingProcess() {
    }

    public VotingProcess(String title, String description, Date startDate, Date endDate, String creatorId) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // toString() method
    @Override
    public String toString() {
        return "VotingProcess{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", description='" + description
                + '\'' + ", startDate=" + startDate + ", endDate=" + endDate;
    }
}