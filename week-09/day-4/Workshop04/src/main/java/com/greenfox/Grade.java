package com.greenfox;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Rita on 2016-12-29.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "grades")
@EqualsAndHashCode
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //    private long studentId;
//    private String codeClass;
    private int grade;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToOne
    @JoinColumn(name = "code_class")
    private Subject classCode;

    @Override
    public String toString() {
        return student.getName() + " got " + grade + " in " + classCode.toString();
    }
}
