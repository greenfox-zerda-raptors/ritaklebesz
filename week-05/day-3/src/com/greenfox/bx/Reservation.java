package com.greenfox.bx;

/**
 * Created by Rita on 2016-11-16.
 */
public class Reservation implements Reservationy {

    String dowBooking;
    String codeBooking;
    final static String ls = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Reservation() {
        this("MON");
    }

    public Reservation(String dowBooking) {
        this.dowBooking = dowBooking;
        this.codeBooking = randomZeroToZ(8);
    }

    @Override
    public String getDowBooking() {
        return dowBooking;
    }

    @Override
    public void setDowBooking(String dowBooking) {
        this.dowBooking = dowBooking;
    }

    @Override
    public String getCodeBooking() {
        return codeBooking;
    }

    @Override
    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    static String randomZeroToZ(int len) {
        String out = "";
        for(int i= 0; i<len; i++) {
            out += ls.charAt((int) (Math.random() * 36));
        }
        return out;
    }

    @Override
    public boolean PlaceReserved(String dowBooking, String codeBooking) {
        this.setDowBooking(dowBooking);
        this.setCodeBooking(codeBooking);
        return true;
    }

    @Override
    public boolean PlaceCancelled(String dowBooking, String codeBooking) {
        this.setCodeBooking(null);
        this.setDowBooking(null);
        return true;
    }

    @Override
    public String toString() {
        return "Booking# " + codeBooking + " for " + dowBooking;
    }
}
