package com.example.rita.myapplication;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Rita on 2016-12-23.
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Message {
    private String name;
    private String text;
    private String time;
    
    public Message(String name, String text, String time){
        this.name = name;
        this.text = text;
        this.time = time;
    }
    
    public String toString(){
        return String.format("Sent by: %s, %s, on %s", name, text, time);
    }
}
