package com.greenfoxacademy.java.lesson.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfig {

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    @Scope("prototype")
    public WithFries withFries(boolean salted) {  //IntelliJ will complain, but still compile
        return new WithFries(salted);
    }
}
