package com.greenfox.exams.java.retake;

import java.util.ArrayList;

/**
 * Created by Rita on 2016-12-15.
 */
public class Carrier {
    private int totalAmmo;
    private int HP;
    private ArrayList<Aircraft> aircrafts;

    public Carrier(int totalAmmo) {
        this.totalAmmo = totalAmmo;
        this.HP = 3000;
    }

    public int getAllDamage() {
        int damage = 0;
        for (Aircraft ac : aircrafts) {
            damage += ac.getAllDamage();
        }
        return damage;
    }

    public void addAircraft(String type) {
        if (type.equals("F16")) {
            aircrafts.add(new F16());
        } else if (type.equals("F35")) {
            aircrafts.add(new F35());
        }
    }

    public void fill() {
        for (Aircraft a : aircrafts) {
            totalAmmo = a.refill(totalAmmo);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aircraft count: ");
        sb.append(aircrafts.size());
        sb.append(", Ammo Storage");
        sb.append(totalAmmo);
        sb.append(", Total Demage:");
        sb.append(getAllDamage());
        sb.append(", Health Remaining: ");
        sb.append(HP);
        sb.append("\n");
        sb.append("Aircrafts:\n");
        for (Aircraft a : aircrafts) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
}
