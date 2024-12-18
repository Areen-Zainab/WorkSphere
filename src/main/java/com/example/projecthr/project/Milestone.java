package com.example.projecthr.project;

import utility.Factory;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Milestone {
    ArrayList<Task> tasks;  //composition

    private int milestoneId;
    private int projectId;
    private String milestoneName;
    private String description;
    private Date startDate;
    private Date endDate;
    private String comments;
    private String status;
    private String priority;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String filePath;

    // Constructor
    public Milestone(int milestoneId, int projectId, String milestoneName, String description, Date startDate,
                     Date endDate, String comments, String status, String priority, Timestamp createdAt, Timestamp updatedAt, String filePath) {
        this.milestoneId = milestoneId;
        this.projectId = projectId;
        this.milestoneName = milestoneName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.comments = comments;
        this.status = status;
        this.priority = priority;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.filePath = filePath;
    }

    // Getters and Setters
    public int getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(int milestoneId) {
        this.milestoneId = milestoneId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getMilestoneName() {
        return milestoneName;
    }

    public void setMilestoneName(String milestoneName) {
        this.milestoneName = milestoneName;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ArrayList<Task> getTasks() {
        if(tasks == null)
            loadTasks();
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void loadTasks(){
        tasks = Factory.getProjectServices().getTasksByMilestoneId(milestoneId);
    }
}
