package com.greenfox.services;

public class SpellChecker {

    public SpellChecker() {
        System.out.println("Inside SpellChecker constructor.");
    }

    public void checkSpelling(String tx) {
        System.out.printf("Inside checkSpelling, %s is a word.\n", tx);
    }
}
