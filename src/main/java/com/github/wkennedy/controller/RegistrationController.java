package com.github.wkennedy.controller;

import com.github.wkennedy.model.Registration;
import com.github.wkennedy.service.RegistrationService;
import com.github.wkennedy.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegistrationValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveRegistration(@Valid @RequestBody Registration registration) {
        registrationService.saveRegistration(registration);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Registration> getRegistrations() {
        return registrationService.getRegistrations();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRegistrations() {
        registrationService.deleteRegistrations();
    }

}
