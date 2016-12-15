package com.greenfox.exams.java.retake;

/**
 * Created by Rita on 2016-12-15.
 */
public abstract class Aircraft {
    private int currentAmmo;

    public Aircraft() {
        currentAmmo = 0;
    }

    public abstract int getBaseDamage();
    public abstract int getMaxAmmo();

    public int fight() {
        int demage = currentAmmo * getBaseDamage();
        currentAmmo = 0;
        return demage;
    }

    public int refill(int fillingAmmo) {
        int ammoNeeded = getMaxAmmo() - currentAmmo;
        if (ammoNeeded >= fillingAmmo) {
            currentAmmo += fillingAmmo;
            return 0;
        } else {
            currentAmmo = getMaxAmmo();
            return fillingAmmo-ammoNeeded;
        }
    }

    public int getAllDamage () {
        return getBaseDamage()*getMaxAmmo();
    }

    @Override
    public String toString() {
        return "Type" + getClass().getSimpleName() + ", Ammo:" + currentAmmo
                + ", BaseDamage: " + getBaseDamage() + ", AllDamage: " +
                getAllDamage();
    }
}
