import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rita on 2016-12-07.
 */
public class GameObjectContainer extends ArrayList<GameObject> {

    public boolean isBossAlive() {
        boolean result = false;
        for (GameObject go : this) {
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
        Tile tile = (Tile) this.get(random.nextInt(this.size()));
        while (!tile.isCanSteppedOn()) {
            tile = (Tile) this.get(random.nextInt(this.size()));
        }
        return tile.getCoordinates();
    }

    public void draw(Graphics graphics) {
        for (GameObject gameObject : this){
            gameObject.draw(graphics);
        }
    }

    public GameObject get(int[] coordinates) {
        GameObject searchedGameObject;
        for (GameObject gameObject : this) {
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
                    this.add(new Wall(i, j));
                } else {
                    this.add(new Floor(i, j));
                }
            }
        }
    }
}
