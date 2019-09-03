package com.example.qtestingserver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
@Controller
//@RequestMapping("/")
public class HomeController {

    // https://stackoverflow.com/questions/40765007/spring-boot-mvc-not-returning-my-view

    //@GetMapping("/")
    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
            //consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            //produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String index() {
        return "index";
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET
    )
    public String homePage(){
        return "home";
    }

}
