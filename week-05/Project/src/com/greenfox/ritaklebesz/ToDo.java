package com.greenfox.ritaklebesz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Rita on 2016-11-17.
 */
public class ToDo {
    static Scanner userInput = new Scanner(System.in);
    static String[] userInputProcessed = new String[2];
    static String rawInput;
    static ArrayList<String> commands = new ArrayList<>(Arrays.asList("list","l","add","a","remove","r","complete","c","help","h", "quit", "q"));
    static ArrayList<String> explanation = new ArrayList<>(Arrays.asList("Lists all the tasks", "shorthand for list", "Adds a new task", "shorthand for add", "Removes an task", "shorthand for remove", "Completes an task", "shorthand for complete", "Print out this list again", "shorthand for help", "Quit the app", "shorthand for quit"));


    public static String[] inputHandler(String... args) {
        rawInput = userInput.nextLine();
        ArrayList<String> userInputToProcess = new ArrayList<>(Arrays.asList(rawInput.split(" ")));
        String argument = userInputToProcess.get(0);
        String task = "";
        for (int i = 1; i < userInputToProcess.size(); i++) {
            task += userInputToProcess.get(i) + " ";
        }
        userInputProcessed[0] = argument;
        userInputProcessed[1] = task;
        return userInputProcessed;
    }

    public static void commandManager(String[] userInputProcessed, ListOfItems listOfItems) {
        if (!commandVerifier(userInputProcessed[0])) {
            System.out.println("Unsupported argument");
        } else {
            if (userInputProcessed[0].toLowerCase() == "add" || userInputProcessed[0].toLowerCase() == "a") {
                try {
                    listOfItems.add(new Item(userInputProcessed[1]));
                } catch (Exception e) {
                    System.out.println("Unable to add: No task is provided");
                }
            } else if (userInputProcessed[0].toLowerCase() == "remove" || userInputProcessed[0].toLowerCase() == "r") {
                try {
                    listOfItems.remove(Integer.valueOf(userInputProcessed[1]));
                } catch (NumberFormatException e) {
                    if (userInputProcessed[1] == "") {
                        System.out.println("Unable to remove: No index is provided");
                    } else {
                        System.out.println("Unable to remove: Index is not a number");
                    }
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("Unable to remove: Index is out of bound");
                }
            } else if (userInputProcessed[0].toLowerCase() == "complete" || userInputProcessed[0].toLowerCase() == "c") {
                try {
                    listOfItems.complete(Integer.valueOf(userInputProcessed[1]));
                } catch (NumberFormatException e) {
                    if (userInputProcessed[1] == "") {
                        System.out.println("Unable to complete: No index is provided");
                    } else {
                        System.out.println("Unable to complete: Index is not a number");
                    }
                }catch (IndexOutOfBoundsException e) {
                    System.out.println("Unable to complete: Index is out of bound");
                }
            } else if (userInputProcessed[0].toLowerCase() == "list" || userInputProcessed[0].toLowerCase() == "l") {
                if (listOfItems.isEmpty()) {
                    System.out.println("No todos for today! :)");
                } else {
                    listOfItems.list();
                }
            } else if (userInputProcessed[0].toLowerCase() == "quit" || userInputProcessed[0].toLowerCase() == "q") {
                exit();
            } else {
                printMenu();
            }
        }
    }

    private static boolean commandVerifier(String arg) {
        return commands.contains(arg.toLowerCase());
    }

    private static void printMenu() {
        System.out.printf("%-10s%-50s\n", "Available", "commands");
        toTableLine(commands, explanation);
    }

    private static void toTableLine(ArrayList<String> arrayList1, ArrayList<String> arrayList2) {
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.printf(" %-10s%-50s\n", arrayList1.get(i), arrayList2.get(i));
        }
    }

    private static void exit() {
        System.out.println("Your list is saved. Bye!");
        System.exit(0);
    }

}
