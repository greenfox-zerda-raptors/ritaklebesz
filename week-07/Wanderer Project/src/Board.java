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
    Area badGuys;
    boolean gotKey;
    int[][] map;
    Maze m;

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
        badGuys = new Area();
        badGuys.add(new Monster(5,5,1,true));
        badGuys.add(new Monster(10,2,1,false));
        badGuys.add(new Monster(8,7,1,false));
        badGuys.add(new Boss(10, 4, 1));

        // set the size of your draw board
        setPreferredSize(new Dimension(1100, 800));
        setVisible(true);
        gotKey = false;
        m = new Maze(11, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        // here you have a 720x720 canvas
        // you can create and draw an image using the class below e.g.
        area.draw(graphics);
        badGuys.draw(graphics);
        if (hero != null) {
            hero.draw(graphics);
            graphics.drawString(hero.toString(), 800, 30);
        }
        for (int i = 0; i < badGuys.size(); i++) {
            graphics.drawString(badGuys.get(i).toString(), 800, 60 + 30 * i);
        }
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
            if (badGuys.get(heroCoordinates) != null) {
                Character opponent = (Character) badGuys.get(heroCoordinates);
                hero.battle(opponent);
                if (!opponent.isAlive()) {
                    if (badGuys.get(heroCoordinates).getClass() == Monster.class) {
                        Monster monster = (Monster) badGuys.get(heroCoordinates);
                        if (monster.isHasKey()) {
                            gotKey = true;
                        }
                    }
                    badGuys.remove(opponent);
                    hero.leveling();
                }
                if (!hero.isAlive()) {
                    hero = null;
                }
                if (!badGuys.isBossAlive() && hero.isAlive() && gotKey) {
                    gotKey = false;
                    hero.enterNewArea();
                    area.clear();
                    map = m.generate();
                    area.add(map);
                    badGuys.clear();
                    badGuys.add(new Monster(5,5,hero.getLevel(),true));
                    badGuys.add(new Monster(10,2,hero.getLevel(),false));
                    badGuys.add(new Monster(8,7,hero.getLevel(),false));
                    badGuys.add(new Boss(10, 4, hero.getLevel()));
                }
            }
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
