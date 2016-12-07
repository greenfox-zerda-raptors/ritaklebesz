/**
 * Created by Rita on 2016-12-07.
 */
public class Hero extends Character {

    public Hero() {
        super("hero-down.png", 0, 0, 20, 20, 0, 5, 1);
        int dice = rollDice();
        HP += 3 * dice;
        DP += 2 * dice;
        SP += dice;
        maxHP = 38;
    }

    public void leveling() {
        int dice = rollDice();
        maxHP += dice;
        DP += dice;
        SP += dice;
    }

    @Override
    public void moveUp() {
        posY -= 1;
    }

    @Override
    public void moveDown() {
        posY += 1;
    }

    @Override
    public void moveLeft() {
        posX -= 1;
    }

    @Override
    public void moveRight() {
        posX += 1;
    }

    public void enterNewArea() {
        int dice = rollDice();
        if (dice == 6) {
            HP = maxHP;
        } else if (dice == 5 || dice == 4) {
            HP = (maxHP/3 > HP ? maxHP/3 : HP);
        } else {
            HP = (maxHP/10 > HP ? maxHP/10 : HP);
        }
        posY = 0;
        posX = 0;
        updateImage("hero-down.png");
        level++;
    }
}
