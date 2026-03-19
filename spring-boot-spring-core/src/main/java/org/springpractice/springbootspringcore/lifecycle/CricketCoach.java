package org.springpractice.springbootspringcore.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("####### In CricketCoach Constructor");
    }

    @PostConstruct
    public void start() {
        System.out.println("####### In CricketCoach PostConstruct");
    }

    @PreDestroy
    public void stop() {
        System.out.println("####### In CricketCoach PreDestroy");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Cricket for 30 minutes.";
    }

}
