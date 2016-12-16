package com.greenfox.ritaklebesz;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by Rita on 2016-12-15.
 */
@Getter
public class GUIListOfItems implements ToDoChangeState, TodoDelete {

    private JPanel itemContainer;
    private ListOfItems tasks;


    public GUIListOfItems() throws SQLException {
        tasks = new ListOfItems();
        itemContainer = new JPanel();
        generateItemPanels();
        itemContainer.setLayout(new BoxLayout(itemContainer, BoxLayout.PAGE_AXIS));
        itemContainer.setPreferredSize(new Dimension(500, 600));
    }

    public void generateItemPanels() {

        for (int i = 0; i < tasks.size(); i++) {
            Item item = tasks.get(i);
            GUIItem GUIitem = new GUIItem(item);
            GUIitem.setListener(this);
            GUIitem.setStateListener(this);
            itemContainer.add(GUIitem.getItemPanel());
        }
    }

    @Override
    public void todoDelete(int itemNumber) {
        try {
            tasks.remove(itemNumber);
            itemContainer.removeAll();
            generateItemPanels();
            itemContainer.revalidate();
            itemContainer.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void todoChanged(int itemNumber, JCheckBox box) {
        try {
            tasks.changeState(itemNumber, box);
            itemContainer.removeAll();
            generateItemPanels();
            itemContainer.revalidate();
            itemContainer.repaint();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
