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
@Table(name = "class")
@Getter
@Setter
public class Subject {
    @Id
    private String code;

    @Override
    public String toString() {
        return code;
    }
}
