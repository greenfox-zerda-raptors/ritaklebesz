package com.greenfox.rita.decoder.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Rita on 2017-01-10.
 */

@Entity
@Table(name = "messages")
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int shift;
    private String text;
}
