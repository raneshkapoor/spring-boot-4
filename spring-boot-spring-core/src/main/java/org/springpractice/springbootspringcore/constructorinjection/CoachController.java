package org.springpractice.springbootspringcore.constructorinjection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    private final Coach coach;

    public CoachController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
