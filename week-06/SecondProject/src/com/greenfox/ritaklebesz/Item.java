package com.greenfox.ritaklebesz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Comparator;

/**
 * Created by Rita on 2016-11-17.
 */
public class Item extends JPanel {
//    private int number;
//    private boolean done;
    private JCheckBox state;
    private String task;
    JButton deleteButton;
    Image image;

//    public Item(/*int number, boolean done, */String task) {
//        this.number = number;
//        this.done = done;
//        this.task = task;
//    }

    public Item(String task, boolean done) {
        this.task = task;
        state = new JCheckBox(this.task, done);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
//        this.setMaximumSize(new Dimension(500, 30));
        deleteButton = new JButton();
        image = Toolkit.getDefaultToolkit().createImage("D:\\Green Fox Academy\\greenfox\\ritaklebesz\\week-06\\SecondProject\\src\\delete.png");
        deleteButton.setIcon(new ImageIcon(image));
        deleteButton.setMaximumSize(new Dimension(20, 20));
        this.add(state);
        this.add(Box.createHorizontalGlue());
        this.add(deleteButton);
    }

    public Item(String task) throws Exception {
        this(task, false);
        if (task.equals("")) {
            throw new Exception();
        }
    }

//    @Overridnt compareTo(Item i) {
//        return this.getNumber()-i.getNumber();
//    }

    public static Comparator<Item> CompareByState = new Comparator<Item>() {
        @Override
        public int compare(Item i1, Item i2) {
            return (i1.state.isSelected() ? 1 : 0)-(i2.state.isSelected() ? 1 : 0);
        }
    };

//    @Override
//    public String toString() {
//        return /*number + " - " + (done ? "[X] " : "[ ] ") + */task;
//    }

    public String toWrite() {
        return /*number + */(state.isSelected() ? "1 " : "0 ") + task;
    }

//    public int getNumber() {
//        return number;
//    }

//    public void setNumber(int number) {
//        this.number = number;
//    }

//    public boolean isDone() {
//        return done;
//    }
//
//    public void setDone(boolean done) {
//        this.done = done;
//    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public JCheckBox getState() {
        return state;
    }

    public void setState(JCheckBox state) {
        this.state = state;
    }

    public void changeState() {
        state.setSelected(state.isSelected());
    }
}
