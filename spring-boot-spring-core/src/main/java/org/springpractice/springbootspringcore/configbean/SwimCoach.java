package org.springpractice.springbootspringcore.configbean;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("####### SwimCoach Constructor");
    }

	@Override
	public String getDailyWorkout() {
        return "Practice Swimming for 30 minutes.";
    }

}
