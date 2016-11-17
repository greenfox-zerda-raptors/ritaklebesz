package com.greenfox.ritaklebesz;

import java.util.ArrayList;

/**
 * Created by Rita on 2016-11-17.
 */
public class ListOfItems {
    protected ArrayList<Item> listOfItems;

    public ListOfItems() {
        listOfItems = new ArrayList();
    }

    public void add(Item item) {
        listOfItems.add(0, item);
    }

    public void remove(int num) {
        listOfItems.remove(num-1);
    }

    public void complete(int num) {
        listOfItems.get(num-1).setDone(true);
    }

    public boolean isEmpty(ArrayList listOfItems) {
        if (listOfItems.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
