package com.greenfox.ritaklebesz;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

/**
 * Created by Rita on 2016-12-15.
 */
@Getter
public class GUIListOfItems {

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
        Image image = Toolkit.getDefaultToolkit()
                .createImage("D:\\Green Fox Academy\\greenfox\\ritaklebesz\\week-06\\SecondProject\\src\\delete.png");
        for (int i = 0; i < tasks.size(); i++) {
            final int itemID = tasks.get(i).getNumber();
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.LINE_AXIS));
            JButton deleteButton = new JButton();
            deleteButton.setIcon(new ImageIcon(image));
            deleteButton.setMaximumSize(new Dimension(20, 20));
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        tasks.remove(itemID);
                        itemContainer.removeAll();
                        generateItemPanels();
                        itemContainer.revalidate();
                        itemContainer.repaint();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            JCheckBox state = new JCheckBox(tasks.get(i).getTask(), tasks.get(i).isDone());
            state.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    try {
                        tasks.complete(itemID);
                        itemContainer.removeAll();
                        generateItemPanels();
                        itemContainer.revalidate();
                        itemContainer.repaint();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            itemPanel.add(state);
            itemPanel.add(Box.createHorizontalGlue());
            itemPanel.add(deleteButton);
            itemContainer.add(itemPanel);
        }
    }
}
