package com.greenfox.ritaklebesz;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Rita on 2016-11-17.
 */

@DatabaseTable(tableName = "TodoItems")
public class Item {
    @Getter
    @DatabaseField(generatedId = true)
    private int number;

    @Getter
    @Setter
    @DatabaseField
    private boolean done;

    @Getter
    @DatabaseField
    private String task;

    @Setter
    @DatabaseField
    private boolean archived;

    public Item() {
    }

    public Item(int number, boolean done, String task, boolean archived) {
        this.number = number;
        this.done = done;
        this.task = task;
        this.archived = archived;
    }

    public Item(String task) throws Exception {
        this(0, false, task, false);
        if (task.equals("")) {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return number + " - " + (done ? "[X] " : "[ ] ") + task;
    }
}
