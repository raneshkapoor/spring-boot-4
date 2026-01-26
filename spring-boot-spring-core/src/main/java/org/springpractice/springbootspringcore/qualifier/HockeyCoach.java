package org.springpractice.springbootspringcore.qualifier;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice Hockey for 30 minutes.";
    }

}
