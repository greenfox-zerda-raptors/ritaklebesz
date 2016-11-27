package com.greenfox.ritaklebesz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Rita on 2016-11-27.
 */
public class GUI extends JFrame implements ActionListener, MouseListener, ItemListener {

    JTextField textInput;
    ListOfItems tasks;

    public GUI() throws HeadlessException {
        this.setTitle("ToDo App");
        this.setDefaultCloseOperation(3);
        JPanel container = new JPanel();
        textInput = new JTextField("Add your new tasks here");
        textInput.addActionListener(this);
        textInput.addMouseListener(this);
        textInput.setMaximumSize(new Dimension(500, 30));
        this.add(container);
        container.add(textInput);
        tasks = new ListOfItems();
        tasks.addMouseListener(this);
        tasks.complete();
        tasks.delete();
        container.setMaximumSize(new Dimension(500, 600));
        container.add(tasks);
        JScrollPane scrollBars = new JScrollPane(tasks, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container.add(scrollBars);
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(500,600));
        pack();
        this.setVisible(true);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(textInput)) {
            try {
                tasks.addItem(new Item(textInput.getText()));
                tasks.complete();
                tasks.delete();
                tasks.loadToFile();
                textInput.setText("Add your new tasks here");
                revalidate();
                repaint();
            } catch (Exception ex) {
                textInput.setText("Add your new tasks here");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(textInput)) {
            textInput.setText("");
        }
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        tasks.complete();
        tasks.loadToFile();
        revalidate();
        repaint();
    }
}
