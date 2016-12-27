package com.greenfox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor {
    //    //field-based DI
//    @Autowired
    private SpellChecker spellChecker;

//    //constructor-based DI
//    @Autowired
//    public TextEditor(SpellChecker spellChecker) {
//        this.spellChecker = spellChecker;
//    }

    //setter-based dependency injection
    @Autowired
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck(String tx) {
        spellChecker.checkSpelling(tx);
    }

    @Override
    public String toString() {
        return spellChecker.toString();
    }
}
