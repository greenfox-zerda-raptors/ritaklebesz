package com.greenfox.ritaklebesz;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

/**
 * Created by Rita on 2016-12-15.
 */
public class GIUToDo extends JPanel {

    @Getter
    JTextField textField;
    GUIListOfItems tasks;
    JFrame frame;

    public GIUToDo() throws SQLException {
        frame = new JFrame();
        frame.add(this);
        frame.setTitle("ToDo App");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textField = new JTextField("Add your tasks here");
        tasks = new GUIListOfItems();
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                textField.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tasks.getTasks().add(new Item(textField.getText()));
                    tasks.getItemContainer().removeAll();
                    tasks.getItemContainer().revalidate();
                    tasks.getItemContainer().repaint();
                    frame.revalidate();
                    frame.repaint();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                textField.setText("Add your new tasks here");
                frame.revalidate();
                frame.repaint();
            }
        });
        textField.setMaximumSize(new Dimension(500, 30));
        this.add(textField);
        this.add(tasks.getItemContainer());
        this.setPreferredSize(new Dimension(500, 600));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        frame.pack();
        frame.setVisible(true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (frame.getWidth() / 2);
        int yPos = (dim.height / 2) - (frame.getHeight() / 2);
        frame.setLocation(xPos, yPos);
    }
}
