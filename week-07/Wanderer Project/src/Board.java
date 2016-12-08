import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Rita on 2016-12-06.
 */
public class Board extends JComponent implements KeyListener {
    GameObjectContainer area;
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

        area = new GameObjectContainer();
        area.add(map);
        hero = new Hero();
        badGuys = new GameObjectContainer();
        badGuys.add(new Monster(5, 5, 1, true));
        badGuys.add(new Monster(10, 2, 1, false));
        badGuys.add(new Monster(8, 7, 1, false));
        badGuys.add(new Boss(10, 4, 1));

        setPreferredSize(new Dimension(1100, 800));
        setVisible(true);
        m = new Maze(20, 18);
    }

    @Override
    public void paint(Graphics graphics) {
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
        if (hero != null) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                move("right", 1, 0, hero);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                move("left", -1, 0, hero);
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                move("up", 0, -1, hero);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                move("down", 0, 1, hero);
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                handleBattle();
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void move(String direction, int x, int y, Character gameCharacter) {
        int[] oldCoordinates = hero.getCoordinates();
        int[] newCoordinates = new int[]{oldCoordinates[0] + x, oldCoordinates[1] + y};
        if (area.isValidStep(newCoordinates)) {
            gameCharacter.move(x, y);
        }
        if (gameCharacter.equals(hero)) {
            hero.updateImage(String.format("hero-%s.png", direction));
        }
    }

    private void handleBattle() {
        int[] heroCoordinates = hero.getCoordinates();
        if (badGuys.get(heroCoordinates) != null) {
            Character opponent = (Character) badGuys.get(heroCoordinates);
            hero.battle(opponent);
            if (checkHeroState()) {
                postBattleCleanUp(opponent);
                levelUp();
            }
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
        area.clear();
        map = m.generate();
        area.add(map);
    }

    private void generateNewOpponents() {
        badGuys.clear();
        for (int i = 0; i < (hero.getLevel() / 3 > 2 ? hero.getLevel() / 3 : 2); i++) {
            badGuys.add(new Monster(area.getRandomValidCoordinates(), hero.getLevel(), false));
        }
        badGuys.add(new Monster(area.getRandomValidCoordinates(), hero.getLevel(), true));
        badGuys.add(new Boss(area.getRandomValidCoordinates(), hero.getLevel()));
    }
}
