import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static java.awt.event.KeyEvent.VK_RIGHT;

/**
 * Created by Rita on 2016-12-06.
 */
public class Board extends JComponent implements KeyListener {
    Area area;
    Hero hero;
    Monster monsterWithKey;
    Monster monster1;
    Monster monster2;
    Boss boss;


    public Board() {

        int[][] map = new int[][]{
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0}
        };

        area = new Area();
        area.add(map);
        hero = new Hero();
        monsterWithKey = new Monster(5,5,1,true);
        monster1 = new Monster(10,2,1,true);
        monster2 = new Monster(8,7,1,true);
        boss = new Boss(10, 4, 1);
        // set the size of your draw board
        setPreferredSize(new Dimension(800, 800));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        // here you have a 720x720 canvas
        // you can create and draw an image using the class below e.g.
        area.draw(graphics);
        monsterWithKey.draw(graphics);
        monster1.draw(graphics);
        monster2.draw(graphics);
        boss.draw(graphics);
        hero.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0]+1, oldCoordinates[1]};
            if (area.isValidStep(newCoordinates)) {
                hero.moveRight();
            }
            hero.updateImage("hero-right.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0]-1, oldCoordinates[1]};
            if (area.isValidStep(newCoordinates)) {
                hero.moveLeft();
            }
            hero.updateImage("hero-left.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1]-1};
            if (area.isValidStep(newCoordinates)) {
                hero.moveUp();
            }
            hero.updateImage("hero-up.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1]+1};
            if (area.isValidStep(newCoordinates)) {
                hero.moveDown();
            }
            hero.updateImage("hero-down.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            int[] heroCoordinates = hero.getCoordinates();

            repaint();
        }
    }

//    private boolean isValidMove(int[] newCoordinates) {
//        return
//    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
