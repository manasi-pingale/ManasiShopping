package com.example.demo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String homePage()
    {
        return "this is home page";
    }

    @GetMapping("/about")
    public String abouPage()
    {
        return "this is about page";
    }
}
