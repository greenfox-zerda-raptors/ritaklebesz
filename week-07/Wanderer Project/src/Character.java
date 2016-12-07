import java.util.Random;

/**
 * Created by Rita on 2016-12-06.
 */
public abstract class Character extends GameObject {
    protected int HP, DP, SP, level;

    public Character(String filename, int posX, int posY, int HP, int DP, int SP, int level) {
        super(filename, posX, posY);
        this.HP = HP;
        this.DP = DP;
        this.SP = SP;
        this.level = level;
    }

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();

    public void battle(Character attackedCharacter) {
        attackedCharacter.attacked(strike());
        attacked(attackedCharacter.strike());
    }

    public int strike() {
        int SV = SP + 2*rollDice();
        return SV;
    }

    public void attacked(int SV) {
        if (SV > DP) {
            HP = HP - (SV-DP);
        }
    }

    public int rollDice() {
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public boolean isAlive() {
        return HP > 0;
    }

    @Override
    public String toString() {
        return String.format("%s (Level %d) HP: %d/10 | DP: %d | SP: %d", getClass(), level, HP, DP, SP);
    }
}
