/**
 * File I/O: The copy command exercise
 * <p>
 * This is just standard I/O and it's usually given as an early IT assignment.
 * <p>
 * Given all that you've already seen and done, this should be fairly easy.
 * <p>
 * This is how it should work, but NOTE ...
 * >>> means that what the computer does; and
 * <<< is what you the user does.
 * <p>
 * >>> Enter the Source filename (assuming reading from C:\TEMP\) or give a different path name to?
 * <<< TestA.txt
 * >>> File does not exist, try again or blank to exit
 * <<< Test.txt
 * >>> Enter the Target filename (assuming writing to C:\TEMP\) or give a different path name?
 * <<< NewTest.txt
 * >>> Writing from C:\TEMP\Test.txt to C:\TEMP\NewTest.txt.  Press Y to confirm, N to abort.
 * <<< Y
 * >>> Done, wrote 102 Characters to C:\TEMP\NewTest.txt.
 * <p>
 * Note that you should compute the working directory (e.g. C:\TEMP\).
 */

import java.io.*;
import java.util.Scanner;


public class Workshop17 {
    // get the directory
    // get the names & confirm the source is okay and if the target exists ignore error (if already exists)
    // confirm action
    // confirm
    // read/write and count
    // report

    static File source;
    static File dest;
    static Scanner userInput = new Scanner(System.in);
    static File parentDirTest;
    static PrintWriter infoToWrite;

    public static void main(String[] args) {

        String sourcePath = "a";
        String destPath = "b";

        boolean loopCond = true;
        while (loopCond) {
            System.out.println("Please provide an absolute path and file name to copy!(blank to quit)");
            System.out.print("Path: ");

            sourcePath = userInput.nextLine();
            source = new File(sourcePath);
            if (sourcePath.equalsIgnoreCase("")) {
                break;
            }

            System.out.println("Please provide an absolute path and file name for the copy.");
            System.out.print("Path: ");
            destPath = userInput.nextLine();
            dest = new File(destPath);
            try {
                parentDirTest = new File(dest.getParent());
                if (source.exists() && !source.isDirectory() && parentDirTest.exists() && parentDirTest.isDirectory()) {
                    loopCond = false;
                }
            } catch (NullPointerException e) {
                System.out.println("No such file or directory.");
            }
        }
        if (!sourcePath.equalsIgnoreCase("") && !destPath.equalsIgnoreCase("")) {
            try {
                BufferedReader getInfo = new BufferedReader(
                        new FileReader(source));
                String lineInSource = getInfo.readLine();
                infoToWrite = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(dest)));
                while (lineInSource != null) {
                    infoToWrite.println(lineInSource);
                    lineInSource = getInfo.readLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
            } catch (IOException e) {
                System.out.println(e.toString());
            } finally {
                infoToWrite.close();
            }
        }
    }
}
