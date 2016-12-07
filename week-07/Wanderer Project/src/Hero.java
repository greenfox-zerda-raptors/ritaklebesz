/**
 * Created by Rita on 2016-12-07.
 */
public class Hero extends Character {

    public Hero() {
        super("hero-down.png", 0, 0, 20, 0, 5, 1);
        int dice = rollDice();
        HP += 3 * dice;
        DP += 2 * dice;
        SP += dice;
    }

    @Override
    public void moveUp() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
