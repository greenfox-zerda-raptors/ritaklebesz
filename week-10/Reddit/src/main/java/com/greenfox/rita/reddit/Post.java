package com.greenfox.rita.reddit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Rita on 2017-01-04.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    private int score;

    public Post(String content) {
        this.content = content;
        score = 0;
    }

    public void increaseScore() {
        score++;
    }

    public void decreaseScore() {
        score--;
    }
}
