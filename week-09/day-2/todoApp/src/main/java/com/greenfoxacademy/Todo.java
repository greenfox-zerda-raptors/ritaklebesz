package com.greenfoxacademy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Rita on 2016-12-20.
 */
@Getter
@Setter
@AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private boolean urgent;
    private boolean done;

    public Todo(int id, String title) {
        this(id, title, false, false);
    }
}
