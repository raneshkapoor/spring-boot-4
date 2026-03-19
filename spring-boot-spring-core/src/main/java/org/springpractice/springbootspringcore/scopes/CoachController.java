package org.springpractice.springbootspringcore.scopes;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/scopes")
public class CoachController {

    private final Coach cricketCoach;

    private final Coach newCricketCoach;

    private final Coach hockeyCoach;

    private final Coach newHockeyCoach;

    public CoachController(@Qualifier("cricketCoach") Coach cricketCoach, @Qualifier("cricketCoach") Coach newCricketCoach,
                           @Qualifier("hockeyCoach") Coach hockeyCoach, @Qualifier("hockeyCoach") Coach newHockeyCoach) {
        this.cricketCoach = cricketCoach;
        this.newCricketCoach = newCricketCoach;
        this.hockeyCoach = hockeyCoach;
        this.newHockeyCoach = newHockeyCoach;
    }

    @GetMapping("/getdailyworkout")
    public String getDailyWorkout() {
        return cricketCoach.getDailyWorkout();
    }

    @GetMapping("/checkScopes")
    public String checkScopes() {
        return "cricket : " + Objects.equals(cricketCoach, newCricketCoach) +
                "\n" +
                "hockey : " + Objects.equals(hockeyCoach, newHockeyCoach);
    }

}
