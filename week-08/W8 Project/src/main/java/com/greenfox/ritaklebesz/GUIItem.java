package com.greenfox.ritaklebesz;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Rita on 2016-12-16.
 */
public class GUIItem {
    private Item item;
    private JButton deleteButton;
    private JCheckBox state;
    @Setter
    private TodoDelete listener;
    @Setter
    private ToDoChangeState stateListener;
    @Getter
    private JPanel itemPanel;
    private Image image = Toolkit.getDefaultToolkit()
            .createImage("D:\\Green Fox Academy\\greenfox\\ritaklebesz\\week-06\\SecondProject\\src\\delete.png");

    public GUIItem(Item item) {
        this.item = item;
        itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.LINE_AXIS));
        deleteButton = new JButton();
        deleteButton.setIcon(new ImageIcon(image));
        deleteButton.setMaximumSize(new Dimension(20, 20));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.todoDelete(GUIItem.this.item.getNumber());
            }
        });
        state = new JCheckBox(item.getTask(), item.isDone());
        state.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                stateListener.todoChanged(GUIItem.this.item.getNumber(), GUIItem.this.state);
            }
        });
        itemPanel.add(state);
        itemPanel.add(Box.createHorizontalGlue());
        itemPanel.add(deleteButton);
    }
}
