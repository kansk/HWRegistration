package com.github.wkennedy.service;

import com.github.wkennedy.model.Registration;

import java.util.List;

public interface RegistrationService {
    /**
     * @param registration - the person and address to persist to the database
     */
    void saveRegistration(Registration registration);

    /**
     * @return a list of persons and their associated address as a registration
     */
    List<Registration> getRegistrations();

    /**
     * Remove all persons from the database
     */
    void deleteRegistrations();
}
