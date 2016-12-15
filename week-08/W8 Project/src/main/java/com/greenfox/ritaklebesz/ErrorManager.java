package com.greenfox.ritaklebesz;

/**
 * Created by Rita on 2016-11-19.
 */
public class ErrorManager {
    private String command;
    private Exception exception;
    private String task;

    protected ErrorManager(String command, Exception exception, String task) {
        this.command = command;
        this.exception = exception;
        this.task = task;
    }

    protected String errorIdentifier() {
        if (exception instanceof IndexOutOfBoundsException) {
            return "Unable to " + command + ": Index is out of bound";
        }
        else if (exception instanceof NumberFormatException) {
            if (task.equals("")) {
                return "Unable to " + command + ": No index is provided";
            } else {
                return "Unable to "+ command + ": Index is not a number";
            }
        } else {
            return "Unable to add: No task is provided";
        }
    }
}
