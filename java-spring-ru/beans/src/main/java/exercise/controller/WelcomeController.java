package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// BEGIN
import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;

@RestController("/welcome")
public class WelcomeController {

    @Autowired
    private Daytime daytime;

    @GetMapping(path = "")
    public String hello() {
        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }
}
// END
