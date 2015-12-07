package com.github.wkennedy.service;

import com.github.wkennedy.model.Registration;

import java.util.List;

public interface RegistrationService {
    void saveRegistration(Registration registration);

    List<Registration> getRegistrations();

    void deleteRegistrations();
}
