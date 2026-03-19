package org.springpractice.springbootspringcore.configbean;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Cricket for 30 minutes.";
    }

}
