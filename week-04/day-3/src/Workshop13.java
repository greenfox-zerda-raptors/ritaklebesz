/**
 * File I/O: Scan a Directory
 * <p>
 * There are situations where you'll need to find stuff in a directory.  In this challenge, you're asking the
 * user to tell you where to look and handling the error if the user tells you something wrong.
 * <p>
 * What we mentors want to see is a function that will list the contents (files and directories) that are
 * beneath a particular path; handle the error if it does not exist.
 * <p>
 * Additionally, say somebody enters a file name down a particular path and that path is right, but the
 * file does not exist.  No problem, the person must have made a mistake.  So say, "hey, that file isn't there,
 * perhaps you want one of these instead" and then show the contents of the directory.  For example:-
 * PATH/FILE?
 * C:\Temp\Marley.txt
 * SORRY, No Marley.txt in C:\Temp, here're the files in that directory
 * Tosh.txt
 * Wailer.txt
 * Cliff.txt
 * <p>
 * Lastly handle users writing C:\TEMP and C:\TEMP\.  And if there's a file called "TEMP" in the C: drive
 * show that.
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Workshop13 {
    static File dirToCheck;
    static File parentDir;

    public static void main(String[] args) {

        System.out.println("Please provide an absolute path and I will list the contents of it! (Type 'q' to quit)");

        Scanner userInput = new Scanner(System.in);

        String pathToList;

        System.out.print("Path: ");

        while (userInput.hasNextLine()) {
            pathToList = userInput.nextLine();
            if (pathToList.equals("q"))
                break;
            printDirectoryContents(pathToList);
            System.out.print("Path: ");
        }
    }

    private static void printDirectoryContents(String pathToList) {
        // Implement this function
        // List all files and directories at the specified path
        // If a specified path does not exist write "The specified path does not exists!"
        // If a specified path is a file and not a directory then list all the contents of the specified file's parent
        // directory (example: input is c:\myfolder\myfile.txt then the function should list contents of c:\myfolder\

        dirToCheck = new File(pathToList);
        if (dirToCheck.exists()) {
            if (dirToCheck.isDirectory()) {
                String[] filesInDir = dirToCheck.list();
                System.out.println(Arrays.toString(filesInDir));
            } else {
                parentDir = new File(dirToCheck.getParent());
                String[] filesInDir = parentDir.list();
                System.out.println(Arrays.toString(filesInDir));
            }
        } else {
            try {
                parentDir = new File(dirToCheck.getParent());
                if (parentDir.exists()) {
                    String[] filesInDir = parentDir.list();
                    System.out.println("SORRY, no such file, here're the files in that directory");
                    System.out.println(Arrays.toString(filesInDir));
                }
            } catch (NullPointerException e) {
                System.out.println("The specified path does not exists!");
            }
        }
    }
}
