package com.greenfox.bx;

/**
 * Created by Rita on 2016-11-16.
 */
public class CreditCardReservation implements CreditCardy,Reservationy {
    private CreditCardy cc;
    private Reservationy res;

    public CreditCardReservation() {
        cc = new CreditCard();
        res = new Reservation();
    }

    public CreditCardReservation(String dowBooking, int sumCVV, String nameCardholder, String codeAccount) {
        res = new Reservation(dowBooking);
        cc = new CreditCard(sumCVV, nameCardholder, codeAccount);
    }

    @Override
    public void setSumCVV(int sumCVV) {
        cc.setSumCVV(sumCVV);
    }

    @Override
    public int getSumCVV() {
        return cc.getSumCVV();
    }

    @Override
    public void setNameCardholder(String nameCardholder) {
        cc.setNameCardholder(nameCardholder);
    }

    @Override
    public String getNameCardholder() {
        return cc.getNameCardholder();
    }

    @Override
    public void setCodeAccount(String codeAccount) {
        cc.setCodeAccount(codeAccount);
    }

    @Override
    public String getCodeAccount() {
        return cc.getCodeAccount();
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        return cc.cumeSumCVV(codeAccount);
    }

    @Override
    public boolean ValidCard(String codeAccount, int sumCVV) {
        return cc.ValidCard(codeAccount, sumCVV);
    }

    @Override
    public void setDowBooking(String dowBooking) {
        res.setDowBooking(dowBooking);
    }

    @Override
    public String getDowBooking() {
        return res.getDowBooking();
    }

    @Override
    public void setCodeBooking(String codeBooking) {
        res.setCodeBooking(codeBooking);
    }

    @Override
    public String getCodeBooking() {
        return res.getCodeBooking();
    }

    @Override
    public boolean PlaceReserved(String dowBooking, String codeBooking) {
        return res.PlaceReserved(dowBooking, codeBooking);
    }

    @Override
    public boolean PlaceCancelled(String dowBooking, String codeBooking) {
        return res.PlaceCancelled(dowBooking, codeBooking);
    }

    @Override
    public String toString() {
        return res.toString() + " payed by " + cc.toString();
    }
}
