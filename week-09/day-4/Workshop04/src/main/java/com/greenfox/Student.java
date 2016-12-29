package com.greenfox;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Rita on 2016-12-29.
 */

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    private long id;
    private String name;
    private String groupName;

    @Override
    public String toString() {
        return name + " belongs to " + groupName;
    }
}
