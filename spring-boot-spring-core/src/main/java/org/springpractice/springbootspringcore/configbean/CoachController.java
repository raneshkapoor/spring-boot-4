package org.springpractice.springbootspringcore.configbean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configbean")
public class CoachController {

    private final Coach coach;

    public CoachController(@Qualifier("swimCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
