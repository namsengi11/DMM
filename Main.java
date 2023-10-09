package project;

import java.util.ArrayList;
import java.util.Scanner;
import project.Exceptions.OutOfRangeException;
import project.Tasks.Task;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter task in the following format\n" + 
                              "title, description, urgence, importance\n");
            String newTaskInput = sc.nextLine();
            String[] taskArgs = newTaskInput.split(", ");
            try {
                taskList.add(Task.createTask(taskArgs[0], taskArgs[1], Integer.valueOf(taskArgs[2]), Integer.valueOf(taskArgs[3])));
            } catch (OutOfRangeException ore) {
                System.out.println(ore.getMessage());
            }

            for (Task task : taskList) {
                System.out.println(task.toString() + '\n');
            }
        }
    }
}
