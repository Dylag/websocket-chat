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


    @GetMapping
    public String login(@RequestBody User user){
        return service.login(user);
    }

    @PutMapping
    public String reg(@RequestBody User user){
        return service.reg(user);
    }


}
