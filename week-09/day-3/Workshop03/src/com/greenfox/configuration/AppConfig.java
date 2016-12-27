package com.greenfox.configuration;

import com.greenfox.services.SpellChecker;
import com.greenfox.services.TextEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = {"com.greenfox.services"})
public class AppConfig {

//    @Bean
//    public SpellChecker getSpellChecker() {
//        return new SpellChecker();
//    }

    @Bean
    TextEditor textEditor() {
        return new TextEditor();
    }

    @Bean
    @Scope("prototype")
    SpellChecker getSpellChecker(String textWord) {
        return new SpellChecker(textWord);
    }
}
