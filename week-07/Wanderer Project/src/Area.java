import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Rita on 2016-12-07.
 */
public class Area {
    ArrayList<Tile> area;

    public Area() {
        area = new ArrayList<>();
    }

    public boolean isValidStep(int[] coordinates) {
        return get(coordinates).isCanSteppedOn();
    }

    public Tile get(int[] coordinates) {
        Tile searchedTile;
        for (Tile tile : area) {
            if (coordinates.equals(tile.getCoordinates())){
                searchedTile = tile;
                return searchedTile;
            }
        }
        return null;
    }

    public void draw(Graphics graphics) {
        for (Tile tile : area){
            tile.draw(graphics);
        }
    }

    public void add(Tile tile) {
        area.add(tile);
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
