package com.example.utils;

import com.example.model.Task;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.IOException;


public class FileUtil {
    public static void saveTasksToFile(ArrayList<Task> tasks,String filename) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        File file = new File(filename);
        
        try {
            mapper.writeValue(file, tasks);
        } catch (IOException e) {
            System.err.println("Error saving tasks to file: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasksFromFile(String filename) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filename);
        try {
            if (file.exists()) {
                CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Task.class);
                return mapper.readValue(file, listType);
            } else {
                System.out.println("File not found: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks from file: " + e.getMessage());
        }
        
        return new ArrayList<>();
    } 
}
