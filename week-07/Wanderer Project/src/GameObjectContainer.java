import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rita on 2016-12-07.
 */
public class GameObjectContainer {

    private ArrayList<GameObject> container;

    public GameObjectContainer() {
        container = new ArrayList<>();
    }

    public boolean isBossAlive() {
        boolean result = false;
        for (GameObject go : container) {
            if (go.getClass() == Boss.class) {
                result = true;
            }
        }
        return result;
    }

    public boolean isValidStep(int[] coordinates) {
        if (this.get(coordinates) != null) {
            return ((Tile) this.get(coordinates)).isCanSteppedOn();
        } else {
            return false;
        }
    }

    public int[] getRandomValidCoordinates() {
        Random random = new Random();
        Tile tile = (Tile) container.get(random.nextInt(container.size()));
        while (!tile.isCanSteppedOn()) {
            tile = (Tile) container.get(random.nextInt(container.size()));
        }
        return tile.getCoordinates();
    }

    public void draw(Graphics graphics) {
        for (GameObject gameObject : container) {
            gameObject.draw(graphics);
        }
    }

    public GameObject get(int[] coordinates) {
        GameObject searchedGameObject;
        for (GameObject gameObject : container) {
            if (Arrays.equals(coordinates, gameObject.getCoordinates())) {
                searchedGameObject = gameObject;
                return searchedGameObject;
            }
        }
        return null;
    }

    public void add(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1) {
                    container.add(new Wall(i, j));
                } else {
                    container.add(new Floor(i, j));
                }
            }
        }
    }

    public void add(GameObject go) {
        container.add(go);
    }

    public int size() {
        return container.size();
    }

    public void clear() {
        container.clear();
    }

    public GameObject get(int i) {
        return container.get(i);
    }

    public void remove(GameObject go) {
        container.remove(go);
    }
}
