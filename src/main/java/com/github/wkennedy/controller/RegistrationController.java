package com.github.wkennedy.controller;

import com.github.wkennedy.model.Registration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @RequestMapping(method = RequestMethod.POST)
    public void saveRegistration(@RequestBody Registration registration) {
        System.out.println(registration);
    }
}
