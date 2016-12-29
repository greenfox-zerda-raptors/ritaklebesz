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

            log.info("Subjects that students enrolled to:");
            log.info("-------------------------------");
            for (Subject subject : gradeRepository.findAllSubjects()) {
                log.info(subject.toString());
            }
            log.info("");
        };
    }
}
