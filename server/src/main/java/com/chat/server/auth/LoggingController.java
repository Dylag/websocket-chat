package com.chat.server.auth;

import com.chat.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class LoggingController {

    @Autowired
    private final AuthService service;

    @Autowired
    public LoggingController(AuthService service) {
        this.service = service;
    }


    @PostMapping(path = "/login")
    public String login(@RequestBody User user){
        //returns "OK" when login successful
        return service.login(user);
    }

    @PostMapping(path ="/reg")
    public String reg(@RequestBody User user){
        //returns "OK" when reg successful
        return service.reg(user);
    }


}
