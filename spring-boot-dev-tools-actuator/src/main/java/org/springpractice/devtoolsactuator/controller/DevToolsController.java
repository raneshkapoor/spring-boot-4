package org.springpractice.devtoolsactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devtools")
public class DevToolsController {

    @GetMapping("/testapi")
    public String testApi() {
        return "Hello World!";
    }

    @GetMapping("/testapinew")
    public String testApiNew() {
        return "Hello World! First Message";
    }

}
