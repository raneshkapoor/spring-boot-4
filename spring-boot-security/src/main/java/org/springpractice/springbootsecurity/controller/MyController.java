package org.springpractice.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/employee")
    public void common() {
        System.out.println("employee");
    }

    @GetMapping("/manager")
    public void manager()  {
        System.out.println("manager");
    }

    @GetMapping("/admin")
    public void admin()  {
        System.out.println("admin");
    }

}
