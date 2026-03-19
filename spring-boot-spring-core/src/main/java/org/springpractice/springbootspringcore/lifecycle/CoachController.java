package org.springpractice.springbootspringcore.lifecycle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle")
public class CoachController {

    private final Coach coach;

    public CoachController(Coach coach) {
        System.out.println("####### In constructor Controller");
        this.coach = coach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
