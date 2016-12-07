/**
 * Created by Rita on 2016-12-07.
 */
public class Tile extends GameObject {
    public boolean canSteppedOn;

    public Tile(String filename, int posX, int posY, boolean canSteppedOn) {
        super(filename, posX, posY);
        this.canSteppedOn = canSteppedOn;
    }

    public boolean isCanSteppedOn() {
        return canSteppedOn;
    }
}
