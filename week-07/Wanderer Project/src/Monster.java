/**
 * Created by Rita on 2016-12-07.
 */
public class Monster extends Character {
    private boolean hasKey;

    public Monster(int posX, int posY, int level, boolean hasKey) {
        this("skeleton.png", posX, posY, level, level, level, level, level, hasKey);
        int dice = rollDice();
        maxHP = maxHP * 12;
        HP = HP * 2 * dice;
        DP = DP/2 * dice;
        SP = SP * dice;

    }

    public boolean isHasKey() {
        return hasKey;
    }

    public Monster(String filename, int posX, int posY, int HP, int maxHP, int DP, int SP, int level, boolean hasKey) {
        super(filename, posX, posY, HP, maxHP, DP, SP, level);
        this.hasKey = hasKey;
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
