package com.example;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.example.model.Task;
import com.example.service.TaskService;
import com.example.utils.FormatList;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        boolean isDate = false;
        boolean isOption = false;
        int select = 0;
        String date = "";
        final String COMPLETED = "Completed";

        ArrayList<Task> list = new ArrayList<>();
        list = taskService.loadTasksFromFile();

        while (run) {
            System.out.println("\n\nWelcome, choose an action: ");
            System.out.println("1. View To Do List");
            System.out.println("2. Add a task");
            System.out.println("3. Mark a task complete");
            System.out.println("4. Delete a task");
            System.out.println("5. exit");

            String response = scanner.nextLine();

            if (!response.isEmpty() && StringUtils.isNumeric(response)) {
                select = Integer.parseInt(response);
            }

            switch (select) {
                case 1:
                    FormatList.formatList(list);
                    break;
                case 2:
                    System.out.println("\nTitle?");
                    String title = scanner.nextLine();
                    System.out.println("Description?");
                    String description = scanner.nextLine();

                    while (!isDate) {
                        System.out.println("Due Date? (YYYY-MM-DD)");
                        date = scanner.nextLine();

                        if (taskService.isValidDate(date)) {
                            isDate = true;
                        } else {
                            System.out.println("Date must be in YYYY-MM-DD format.");
                        }
                    }

                    LocalDate dueDate = LocalDate.parse(date);

                    taskService.addTask(list, title, description, "Incomplete", dueDate);
                    break;
                case 3:
                    System.out.println("\nWhich task is complete?");
                    while (!isOption) {
                        String answer = scanner.nextLine();
                        try {
                            int index = Integer.parseInt(answer);
                            taskService.updateTaskStatus(list, list.get(index - 1), COMPLETED);
                            System.out.println("\nTask marked complete!");
                            isOption = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index, try again. E: " + e.getMessage());
                        }
                    }
                    isOption = false;

                    break;
                case 4:
                    System.out.println("\nWhich task would you like to remove?");
                    while (!isOption) {
                        String trash = scanner.nextLine();
                        try {
                            int index = Integer.parseInt(trash);
                            taskService.removeTask(list, list.get(index - 1));
                            System.out.println("\nTask removed.\n");
                            isOption = true;
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid index: " + e.getMessage());
                        }
                    }
                    isOption = false;

                    break;
                case 5:
                    run = false;
                    break;
            }
            date = "";
            isDate = false;

        }

        scanner.close();

    }
}