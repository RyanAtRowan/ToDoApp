package com.example.model;

import java.time.LocalDate;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.example.utils.LocalDateArrayDeserializer;

public class Task {
    private String title;
    private String description;
    private String status;
    @JsonDeserialize(using = LocalDateArrayDeserializer.class)
    private LocalDate dueDate;

    public Task() {}


    public Task(String title, String description, String status, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted() {
        this.status = "Completed";
    }

    public void setIncomplete() {
        this.status = "Incomplete";
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String toString() {
        return ("Title: " + title + "\nDescription: " + description + "\nStatus: " + status + "\nDue Date: " + dueDate + "\n\n"); 
    }
}
