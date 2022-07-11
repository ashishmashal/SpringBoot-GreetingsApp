package com.example.greetings.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class AllAPIs {
    @RequestMapping("/hello")
    public String Hello(){
        return "Hello From Bridgelabz";
    }

    @RequestMapping ("/query/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloParam(@RequestParam(value = "name") String name)
    {
        return "Hello " + name + "!";
    }
}
