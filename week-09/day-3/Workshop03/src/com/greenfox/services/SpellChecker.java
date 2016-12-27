package com.greenfox.services;

public class SpellChecker {
    String textWord;
    String codeLanguage = "EN";

//    public SpellChecker() {
//        System.out.println("Inside SpellChecker constructor.");
//    }

    public SpellChecker(String textWord) {
        this.textWord = textWord;
        System.out.println("Inside the new SpellChecker constructor.");
    }

    public void checkSpelling(String tx) {
        System.out.printf("Inside checkSpelling, %s is a word.\n", tx);
    }

    @Override
    public String toString() {
        return String.format("SpellChecking '%s' in '%s'\n", this.textWord, this.codeLanguage);
    }
}
