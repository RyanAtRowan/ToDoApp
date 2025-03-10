package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.example.model.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.example.utils.FileUtil;

public class TaskService {
    String filename = "tasks.json";

    // Add Task
    public void addTask(ArrayList<Task> list, String title, String description, String status, LocalDate dueDate) {
        list.add(new Task(title, description, status, dueDate));
        sortTasks(list);
        saveTasks(list);
    }

    // Remove Task
    public void removeTask(ArrayList<Task> list, Task task) {
        list.remove(task);
        sortTasks(list);
        saveTasks(list);
    }

    // Update Tasks
    public void updateTaskTitle(ArrayList<Task> list, Task task, String title) {
        task.setTitle(title);
        saveTasks(list);
    }

    public void updateTaskDescription(ArrayList<Task> list, Task task, String description) {
        task.setDescription(description);
        saveTasks(list);
    }

    public void updateTaskStatus(ArrayList<Task> list, Task task, String status) {
        if (status.equals("Completed")) {
            task.setCompleted();
        } else {
            task.setIncomplete();
        } 
        saveTasks(list);
    }

    public void updateTaskDueDate(ArrayList<Task> list, Task task, LocalDate dueDate) {
        task.setDueDate(dueDate);
        sortTasks(list);
        saveTasks(list);
    }

    // Validate Date
    public boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    // Sort Tasks
    public void sortTasks(ArrayList<Task> list) {
        Collections.sort(list, Comparator.comparing(Task::getDueDate));
    }

    // Save List
    public void saveTasks(ArrayList<Task> tasks) {
        FileUtil.saveTasksToFile(tasks, filename);
    }

    // Load List
    public ArrayList<Task> loadTasksFromFile() {
        return FileUtil.loadTasksFromFile(filename);
    }
}
