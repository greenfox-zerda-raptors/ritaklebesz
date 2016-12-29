package com.greenfox;

import com.greenfox.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Workshop04Application {
    private static final Logger log = LoggerFactory.getLogger(Workshop04Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Workshop04Application.class, args);
    }

    @Bean
    public CommandLineRunner grades(GradeRepository gradeRepository) {
        return (args) -> {
            log.info("Student and their grades:");
            log.info("-------------------------------");
            for (Grade grade : gradeRepository.findAll()) {
                log.info(grade.toString());
            }
            log.info("");

            log.info("Student and their grades in Demo:");
            log.info("-------------------------------");
            for (Grade grade : gradeRepository.findAll()) {
                if (grade.getClassCode().getCode().equals("Demo")) {
                    log.info(grade.toString());
                }
            }
            log.info("");

            log.info("Student and their grades in Demo with custom method:");
            log.info("-------------------------------");
            Subject subject = new Subject("Demo");
            for (Grade grade : gradeRepository.findBySubjectName(subject)) {
                log.info(grade.toString());
            }
            log.info("");

            log.info("Classes taken:");
            log.info("-------------------------------");
            for (Subject subject2 : gradeRepository.findAllSubjects()) {
                log.info(subject2.toString());
            }
            log.info("");
            log.info("Classes not taken:");
            log.info("-------------------------------");
            for (Subject subject2 : gradeRepository.findSubjectsNotTaken()) {
                log.info(subject2.toString());
            }
            log.info("");
        };
    }
}
