package com.greenfox.ritaklebesz;

import java.util.Comparator;

/**
 * Created by Rita on 2016-11-17.
 */
public class Item implements Comparable<Item> {
    private int number;
    private boolean done;
    private String task;

    public Item(int number, boolean done, String task) {
        this.number = number;
        this.done = done;
        this.task = task;
    }

    public Item(String task) throws Exception {
        this(0, false, task);
        if (task.equals("")) {
            throw new Exception();
        }
    }

    @Override
    public int compareTo(Item i) {
        return this.getNumber()-i.getNumber();
    }

    public static Comparator<Item> CompareByState = new Comparator<Item>() {
        @Override
        public int compare(Item i1, Item i2) {
            return (i1.isDone() ? 1 : 0)-(i2.isDone() ? 1 : 0);
        }
    };

    @Override
    public String toString() {
        return number + " - " + (done ? "[X] " : "[ ] ") + task;
    }

    public String towrite() {
        return number + (done ? " 1 " : " 0 ") + task;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
