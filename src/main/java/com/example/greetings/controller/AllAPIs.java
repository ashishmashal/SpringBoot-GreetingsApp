package com.example.greetings.controller;

import com.example.greetings.model.Greeting;
import com.example.greetings.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AllAPIs {
//    @RequestMapping("/hello")
//    public String Hello(){
//        return "Hello From Bridgelabz";
//    }
//
//    @RequestMapping ("/query/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }
//
//    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
//    public String sayHelloParam(@RequestParam(value = "name") String name)
//    {
//        return "Hello " + name + "!";
//    }

    public static final String template = "Hello & Welcome to the greeting app, %s";
    public final AtomicLong counter = new AtomicLong();
    @Autowired
    public GreetingService service;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/welcome")
    public String displayMessage(){
        return service.greetingMessage();
    }

    @GetMapping("/greetingsWithUser")
    public String greetingWithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName){
        return service.greetingWithUserName(firstName, lastName);
    }

    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return service.saveGreetings(greeting);
    }
    @GetMapping("/greetingById/{id}")
    public Greeting getGreetingById(@PathVariable Integer id){
        return service.findGreetingById(id);
    }
    @GetMapping("/allGreetings")
    public List<Greeting> findAllGreetings() {
        return service.findGreetings();
    }
}
