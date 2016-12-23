package com.example.rita.myapplication;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Rita on 2016-12-23.
 */

public class Message {
    public String name;
    public String text;
    public String time;
    
    public Message(String name, String text, String time){
        this.name = name;
        this.text = text;
        this.time = time;
    }
    
    public String toString(){
        return String.format("Sent by: %s, %s, on %s", name, text, time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
