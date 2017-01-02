package com.greenfox.caloriecounter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Rita on 2016-12-30.
 */
@Entity
@Table(name = "meals")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate date;
    String type;
    String description;
    int calories;

    public LocalDate convertToDate(String string) {
        return LocalDate.parse(string);
    }
}
