/**
 * Created by Rita on 2016-12-07.
 */
public class Hero extends Character {

    public Hero() {
        this("hero-down.png", 0, 0, 20, 20, 0, 5, 1, false);
        int dice = rollDice();
        HP += 3 * dice;
        DP += 2 * dice;
        SP += dice;
        maxHP = 38;
    }

    public Hero(String filename, int posX, int posY, int HP, int maxHP, int DP, int SP, int level, boolean hasKey) {
        super(filename, posX, posY, HP, maxHP, DP, SP, level, hasKey);
    }

    public void leveling() {
        int dice = rollDice();
        maxHP += dice;
        DP += dice;
        SP += dice;
    }

    public void enterNewArea() {
        useKey();
        int dice = rollDice();
        if (dice == 6) {
            HP = maxHP;
        } else if (dice == 5 || dice == 4) {
            HP = (maxHP / 3 > HP ? maxHP / 3 : HP);
        } else {
            HP = (maxHP / 10 > HP ? maxHP / 10 : HP);
        }
        posY = 0;
        posX = 0;
        updateImage("hero-down.png");
        level++;
    }
}
