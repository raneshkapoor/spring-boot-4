package org.springpractice.springbootspringcore.configbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
