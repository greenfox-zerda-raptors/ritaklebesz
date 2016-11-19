package com.greenfox.ritaklebesz;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Rita on 2016-11-17.
 */
public class ListOfItems {

    public ArrayList<Item> listOfItems;
    public String sourcePath = "D:/Green Fox Academy/greenfox/ritaklebesz/week-05/Project/todoList.csv";
    public File file = new File(sourcePath);

    public ListOfItems() {
        listOfItems = new ArrayList();
        loadFromFile();
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
                ArrayList<String> itemToAdd = new ArrayList<>(Arrays.asList(line.split(" ", 3)));
                listOfItems.add(new Item(Integer.valueOf(itemToAdd.get(0)), (Integer.valueOf(itemToAdd.get(1)).equals(1)), itemToAdd.get(2)));
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
                content = item.towrite();
                bw.write(content);
                bw.newLine();
            }
            bw.close();
            System.out.println("Your list is saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Item item) {
        listOfItems.add(0, item);
        organize();
    }

    public void remove(int num) {
        listOfItems.remove(num-1);
        organize();
    }

    public void complete(int num) {
        listOfItems.get(num-1).setDone(true);
        organize();
    }

    public void organize() {
        Collections.sort(listOfItems, Item.CompareByState);
        for (int i = 0; i < listOfItems.size(); i++) {
            listOfItems.get(i).setNumber(i+1);
        }
    }

    public boolean isEmpty() {
        if (listOfItems.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ListOfItems{" +
                "listOfItems=" + listOfItems +
                '}';
    }

    public void list() {
        if (listOfItems.isEmpty()) {
            System.out.println("No todos for today! :)");
        } else {
            for (Item item : listOfItems) {
                System.out.println(item.toString());
            }
        }
    }
}
