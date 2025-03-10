package com.example.utils;

import com.example.model.Task;
import java.util.ArrayList;

public class FormatList {
    public static void formatList(ArrayList<Task> list) {
        int index = 1;
        if (list.isEmpty()) {
            System.out.println("\n\nNothing to do!");
        }
        else {
            System.out.println("\n\n******** To Do ********");
            for (Task task : list) {
                System.out.println(index + ".");
                System.out.println(task.toString());
                index += 1;
            }
        }

    }
}
