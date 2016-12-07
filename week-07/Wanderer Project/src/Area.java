import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rita on 2016-12-07.
 */
public class Area {
    ArrayList<GameObject> area;

    public Area() {
        area = new ArrayList<>();
    }

    public boolean isValidStep(int[] coordinates) {
        if (get(coordinates) != null) {
            return ((Tile) get(coordinates)).isCanSteppedOn();
        } else {
            return false;
        }
    }

    public GameObject get(int[] coordinates) {
        GameObject searchedGameObject;
        for (GameObject gameObject : area) {
            if (Arrays.equals(coordinates, gameObject.getCoordinates())) {
                searchedGameObject = gameObject;
                return searchedGameObject;
            }
        }
        return null;
    }

    public void draw(Graphics graphics) {
        for (GameObject gameObject : area){
            gameObject.draw(graphics);
        }
    }

    public void add(GameObject gameObject) {
        area.add(gameObject);
    }

    public void add(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1) {
                    area.add(new Wall(i, j));
                } else {
                    area.add(new Floor(i, j));
                }
            }
        }
    }
}
