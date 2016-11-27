package com.greenfox.ritaklebesz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rita on 2016-11-17.
 */
public class ListOfItems extends JPanel {

    public ArrayList<Item> listOfItems;
    public String sourcePath = "D:/Green Fox Academy/greenfox/ritaklebesz/week-06/SecondProject/todoList.csv";
    public File file = new File(sourcePath);
//    public JPanel container;

    public ListOfItems() {
        listOfItems = new ArrayList();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        loadFromFile();
        list();
    }

    public void loadFromFile() {
        BufferedReader br = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            String line;

            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                ArrayList<String> itemToAdd = new ArrayList<>(Arrays.asList(line.split(" ", 2)));
                listOfItems.add(new Item(itemToAdd.get(1), (itemToAdd.get(0).equals("1"))));
            }
            br.close();

        } catch (IOException e) {
            System.out.println("Something went wrong during reading the file");
        }
    }

    public void loadToFile() {
        try {

            String content;

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Item item : listOfItems) {
                content = item.toWrite();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
//            System.out.println("Your list is saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem(Item item) {
        listOfItems.add(0, item);
        list();
    }
//
    public void delete() {
        for (Item item : listOfItems) {
            item.deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clear();
                    listOfItems.remove(item);
                    list();
                    repaint();
                    loadToFile();
                }
            });
        }
    }
//
    public void complete() {
        for (Item item : listOfItems) {
            item.getState().addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    item.changeState();
                    list();
                    loadToFile();
                }
            });
        }

    }
//
    public void organize() {
        Collections.sort(listOfItems, Item.CompareByState);
//        for (int i = 0; i < listOfItems.size(); i++) {
//            listOfItems.get(i).setNumber(i+1);
//        }
    }

    public void list() {
        if (listOfItems.isEmpty()) {
            this.add(new JLabel("No todos for today! :)"));
        } else {
            clear();
            organize();
            for (Item item : listOfItems) {
                this.add(item);
            }
            revalidate();
        }
    }

    public void clear() {
        for (Item item : listOfItems) {
            this.remove(item);
        }
    }
}
