package com.greenfox.configuration;

import com.greenfox.services.SpellChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.greenfox.services"})
public class AppConfig {

    @Bean
    public SpellChecker getSpellChecker() {
        return new SpellChecker();
    }
}
