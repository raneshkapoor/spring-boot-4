package org.springpractice.springbootcustomappprops.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customprops")
public class CustomPropsController {

    @Value("${custom.value.message}")
    private String customValue;

    @GetMapping("/customvalue")
    public String getCustomValue() {
        return customValue;
    }

}
