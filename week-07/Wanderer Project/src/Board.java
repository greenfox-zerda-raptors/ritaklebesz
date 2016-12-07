import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Rita on 2016-12-06.
 */
public class Board extends JComponent implements KeyListener {
    GameObjectContainer gameObjectContainer;
    Hero hero;
    GameObjectContainer badGuys;
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

        gameObjectContainer = new GameObjectContainer();
        gameObjectContainer.add(map);
        hero = new Hero();
        badGuys = new GameObjectContainer();
        badGuys.add(new Monster(5,5,1,true));
        badGuys.add(new Monster(10,2,1,false));
        badGuys.add(new Monster(8,7,1,false));
        badGuys.add(new Boss(10, 4, 1));

        setPreferredSize(new Dimension(1100, 800));
        setVisible(true);
        m = new Maze(11, 10);
    }

    @Override
    public void paint(Graphics graphics) {
        gameObjectContainer.draw(graphics);
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
            if (gameObjectContainer.isValidStep(newCoordinates)) {
                hero.moveRight();
            }
            hero.updateImage("hero-right.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0]-1, oldCoordinates[1]};
            if (gameObjectContainer.isValidStep(newCoordinates)) {
                hero.moveLeft();
            }
            hero.updateImage("hero-left.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1]-1};
            if (gameObjectContainer.isValidStep(newCoordinates)) {
                hero.moveUp();
            }
            hero.updateImage("hero-up.png");
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            int[] oldCoordinates = hero.getCoordinates();
            int[] newCoordinates = new int[]{oldCoordinates[0], oldCoordinates[1]+1};
            if (gameObjectContainer.isValidStep(newCoordinates)) {
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
                if (checkHeroState()) {
                    postBattleCleanUp(opponent);
                    levelUp();
                }
            }
            repaint();
        }
    }

    private void postBattleCleanUp(Character opponent) {
        if (!opponent.isAlive()) {
            hero.takeKey(opponent);
            badGuys.remove(opponent);
            hero.leveling();
        }
    }

    private boolean checkHeroState() {
        if (!hero.isAlive()) {
            hero = null;
            return false;
        }
        return true;
    }

    private void levelUp() {
        if (!badGuys.isBossAlive() && hero.isAlive() && hero.isHasKey()) {
            hero.enterNewArea();
            generateNewArea();
            generateNewOpponents();
        }
    }

    private void generateNewArea() {
        gameObjectContainer.clear();
        map = m.generate();
        gameObjectContainer.add(map);
    }

    private void generateNewOpponents() {
        badGuys.clear();
        for (int i = 0; i < (hero.getLevel()/3 > 2 ? hero.getLevel()/3 : 2); i++) {
            badGuys.add(new Monster(gameObjectContainer.getRandomValidCoordinates(),hero.getLevel(),false));
        }
        badGuys.add(new Boss(gameObjectContainer.getRandomValidCoordinates(), hero.getLevel()));
        badGuys.add(new Monster(gameObjectContainer.getRandomValidCoordinates(),hero.getLevel(),true));
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
