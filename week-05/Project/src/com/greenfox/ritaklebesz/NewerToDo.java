package com.greenfox.ritaklebesz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rita on 2016-11-19.
 */
public class NewerToDo {

    Scanner userInput;
    String argument;
    String task;
    String[] userInputProcessed = {argument, task};
    String rawInput;
    ListOfItems listOfItems;
    final ArrayList<String> commands = new ArrayList<>(Arrays.asList("list","l","add","a","remove","r","complete","c","help","h", "quit", "q"));
    final ArrayList<String> explanation = new ArrayList<>(Arrays.asList("Lists all the tasks", "shorthand for list", "Adds a new task", "shorthand for add", "Removes an task", "shorthand for remove", "Completes an task", "shorthand for complete", "Print out this list again", "shorthand for help", "Quit the app", "shorthand for quit"));

    public NewerToDo() {
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
            try {
                if (argument.toLowerCase().equals("add") || argument.toLowerCase().equals("a")) {
                    listOfItems.add(new Item(task));
                } else if (argument.toLowerCase().equals("remove") || argument.toLowerCase().equals("r")) {
                    listOfItems.remove(Integer.valueOf(task));
                } else if (argument.toLowerCase().equals("complete") || argument.toLowerCase().equals("c")) {
                    listOfItems.complete(Integer.valueOf(task));
                } else if (argument.toLowerCase().equals("list") || argument.toLowerCase().equals("l")) {
                     listOfItems.list();
                } else if (argument.toLowerCase().equals("quit") || argument.toLowerCase().equals("q")) {
                    exit();
                } else {
                    printMenu();
                }
            } catch (Exception e) {
                ErrorManager errorManager = new ErrorManager(longCommand(argument), e, task);
                System.out.println(errorManager.errorIdentifier());
            }
        }
    }

    private String longCommand(String argument){
        switch (argument) {
            case "a":
            case "add":
                return "add";
            case "c":
            case "complete":
                return "complete";
            case "r":
            case "remove":
                return "remove";
        }
        return argument;
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
