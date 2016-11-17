package com.greenfox.ritaklebesz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rita on 2016-11-17.
 */
public class NewToDo {
    Scanner userInput;
    String argument;
    String task;
    String[] userInputProcessed = {argument, task};
    String rawInput;
    ListOfItems listOfItems;
    final ArrayList<String> commands = new ArrayList<>(Arrays.asList("list","l","add","a","remove","r","complete","c","help","h", "quit", "q"));
    final ArrayList<String> explanation = new ArrayList<>(Arrays.asList("Lists all the tasks", "shorthand for list", "Adds a new task", "shorthand for add", "Removes an task", "shorthand for remove", "Completes an task", "shorthand for complete", "Print out this list again", "shorthand for help", "Quit the app", "shorthand for quit"));

    public NewToDo() {
        userInput = new Scanner(System.in);
        listOfItems = new ListOfItems();
        argument = "";
        task = "";
        rawInput = "";
    }

    public String[] inputHandler() {
        rawInput = userInput.nextLine();
        ArrayList<String> userInputToProcess = new ArrayList<>(Arrays.asList(rawInput.split(" ", 2)));
        argument = userInputToProcess.get(0);
        task = (userInputToProcess.size() > 1 ? userInputToProcess.get(1) : "");
        return userInputProcessed;
    }

    public void commandManager() {
        if (!commandVerifier()) {
            System.out.println("Unsupported argument");
        } else {
            if (argument.toLowerCase().equals("add") || argument.toLowerCase().equals("a")) {
                try {
                    listOfItems.add(new Item(task));
                } catch (Exception e) {
                    System.out.println("Unable to add: No task is provided");
                }
            } else if (argument.toLowerCase().equals("remove") || argument.toLowerCase().equals("r")) {
                try {
                    listOfItems.remove(Integer.valueOf(task));
                } catch (NumberFormatException e) {
                    if (task.equals("")) {
                        System.out.println("Unable to remove: No index is provided");
                    } else {
                        System.out.println("Unable to remove: Index is not a number");
                    }
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("Unable to remove: Index is out of bound");
                }
            } else if (argument.toLowerCase().equals("complete") || argument.toLowerCase().equals("c")) {
                try {
                    listOfItems.complete(Integer.valueOf(task));
                } catch (NumberFormatException e) {
                    if (task.equals("")) {
                        System.out.println("Unable to complete: No index is provided");
                    } else {
                        System.out.println("Unable to complete: Index is not a number");
                    }
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("Unable to complete: Index is out of bound");
                }
            } else if (argument.toLowerCase().equals("list") || argument.toLowerCase().equals("l")) {
                if (listOfItems.isEmpty()) {
                    System.out.println("No todos for today! :)");
                } else {
                    listOfItems.list();
                }
            } else if (argument.toLowerCase().equals("quit") || argument.toLowerCase().equals("q")) {
                exit();
            } else {
                printMenu();
            }
        }
    }

    private boolean commandVerifier() {
        return commands.contains(argument.toLowerCase());
    }

    public void printMenu() {
        System.out.printf("%-10s%-50s\n", "Available", "commands");
        for (int i = 0; i < commands.size(); i++) {
            System.out.printf(" %-10s%-50s\n", commands.get(i), explanation.get(i));
        }
    }

    private void exit() {
        listOfItems.loadToFile();
        userInput.close();
        System.out.println("Bye!");
        System.exit(0);
    }

}

