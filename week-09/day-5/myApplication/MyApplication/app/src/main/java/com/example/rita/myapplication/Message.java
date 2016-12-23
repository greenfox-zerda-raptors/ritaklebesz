package com.example.rita.myapplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Rita on 2016-12-23.
 */

public class Message {
    public String username;
    public String body;
    public String created_at;
    SimpleDateFormat sdfin = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
    SimpleDateFormat sdfout = new SimpleDateFormat("MMM dd yyyy, HH:mm");
    
    public Message(String name, String text){
        this.username = name;
        this.body = text;
        this.created_at = "";
    }
    
    public String toString(){
        return String.format("Sent by: %s, %s, on %s", username, body, created_at);
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getText() {
        return body;
    }

    public void setText(String text) {
        this.body = text;
    }

    public String getTime() {
        try {
            return sdfout.format(sdfin.parse(created_at));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public void setTime(String time) {
        this.created_at = time;
    }
}
