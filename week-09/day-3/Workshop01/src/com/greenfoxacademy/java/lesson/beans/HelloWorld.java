package com.greenfoxacademy.java.lesson.beans;

public class HelloWorld {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Your Message (from HelloWorld.java): " + message);
    }
}
