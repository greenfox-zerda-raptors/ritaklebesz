/**
 * Created by Rita on 2016-12-07.
 */
public class Boss extends Character {
    public Boss(int posX, int posY, int level) {
        this("boss.png", posX, posY, level, level, level, level, level);
        int dice = rollDice();
        maxHP = maxHP * 12 + 6;
        HP = HP * 2 * dice + dice;
        DP = DP/2 * dice + dice/2;
        SP = SP * dice + SP;
    }

    public Boss(String filename, int posX, int posY, int HP, int maxHP, int DP, int SP, int level) {
        super(filename, posX, posY, HP, maxHP, DP, SP, level);
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
