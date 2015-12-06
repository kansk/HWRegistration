package com.github.wkennedy.validator;

import com.github.wkennedy.model.Address;
import com.github.wkennedy.model.Person;
import com.github.wkennedy.model.Registration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {
    private static final String INVALID_NAME = ".*\\d+.*";
    private static final String VALID_ZIP_CODE = "^[0-9]{5}(?:-[0-9]{4})?$";

    @Override
    public boolean supports(Class<?> aClass) {
        return Registration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Registration registration = (Registration) o;
        if(registration.getPerson() != null) {
            Person person = registration.getPerson();
            if (person.getFirstName().isEmpty()) {
                errors.reject("First name must be provided.");
            } else if(person.getFirstName().matches(INVALID_NAME)) {
                errors.reject("Not a valid first name.");
            } else if (person.getLastName().isEmpty()) {
                errors.reject("Last name must be provided.");
            } else if(person.getLastName().matches(INVALID_NAME)) {
                errors.reject("Not a valid last name.");
            }
        }

        if(registration.getAddress() != null) {
            Address address = registration.getAddress();
            if (address.getAddress1().isEmpty()) {
                errors.reject("Address 1 must be provided.");
            } else if(address.getCity().isEmpty()) {
                errors.reject("City must be provided.");
            } else if(address.getCountry().isEmpty()) {
                errors.reject("Country must be provided.");
            } else if(address.getState().isEmpty()) {
                errors.reject("State must be provided.");
            } else if(address.getZipCode().isEmpty()) {
                errors.reject("Zip Code must be provided.");
            } else if(!address.getZipCode().matches(VALID_ZIP_CODE)) {
                errors.reject("Not a valid zip code");
            }
        }
    }
}
