package com.greenfox.bx;

/**
 * Created by Rita on 2016-11-16.
 */
public class CreditCard implements CreditCardy {
    private int sumCVV;
    private String nameCardholder;
    private String codeAccount;

    public CreditCard() {
        this(0, null, null);
    }

    public CreditCard(int sumCVV, String nameCardholder, String codeAccount) {
        if (sumCVV <= 0) {
            this.sumCVV = cumeSumCVV(codeAccount);
        } else this.sumCVV = sumCVV;
        this.nameCardholder = nameCardholder;
        this.codeAccount = codeAccount;
    }

    public CreditCard(String nameCardholder, String codeAccount) {
        this(0, nameCardholder, codeAccount);
    }

    public int getSumCVV() {
        return sumCVV;
    }

    public void setSumCVV(int sumCVV) {
        this.sumCVV = sumCVV;
    }

    public String getNameCardholder() {
        return nameCardholder;
    }

    public void setNameCardholder(String nameCardholder) {
        this.nameCardholder = nameCardholder;
    }

    public String getCodeAccount() {
        return codeAccount;
    }

    public void setCodeAccount(String codeAccount) {
        this.codeAccount = codeAccount;
    }

    @Override
    public int cumeSumCVV(String codeAccount) {
        int checksum = 0;
        for (int i =0; i < codeAccount.length(); i++) {
            checksum += Integer.parseInt(codeAccount.substring(i, i+1));
        }
        return checksum;
    }

    @Override
    public boolean ValidCard(String codeAccount, int sumCVV) {
        return sumCVV == this.cumeSumCVV(codeAccount);
    }

    @Override
    public String toString() {
        return "Name=" + nameCardholder + " CC#=" + codeAccount + " CVV=" + sumCVV;
    }
}
