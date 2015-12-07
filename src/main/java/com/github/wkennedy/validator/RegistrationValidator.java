package com.github.wkennedy.validator;

import com.github.wkennedy.model.Address;
import com.github.wkennedy.model.Person;
import com.github.wkennedy.model.Registration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RegistrationValidator implements Validator {
    private static final String VALID_ZIP_CODE = "^[0-9]{5}(?:-[0-9]{4})?$";

    @Override
    public boolean supports(Class<?> aClass) {
        return Registration.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Registration registration = (Registration) o;
        if (registration.getPerson() != null) {
            Person person = registration.getPerson();
            validatePerson(person, errors);
        }

        if (registration.getAddress() != null) {
            Address address = registration.getAddress();
            validateAddress(address, errors);
        }
    }

    private void validatePerson(Person person, Errors errors) {
        if (person.getFirstName().isEmpty()) {
            errors.reject("First name must be provided.");
            return;
        } else if (!StringUtils.isAlpha(person.getFirstName())) {
            errors.reject("Not a valid first name.");
            return;
        } else if (person.getLastName().isEmpty()) {
            errors.reject("Last name must be provided.");
            return;
        } else if (!StringUtils.isAlpha(person.getFirstName())) {
            errors.reject("Not a valid last name.");
            return;
        }
    }

    private void validateAddress(Address address, Errors errors) {
        if (address.getAddress1().isEmpty()) {
            errors.reject("Address 1 must be provided.");
            return;
        } else if (address.getCity().isEmpty()) {
            errors.reject("City must be provided.");
            return;
        } else if (!StringUtils.isAlpha(address.getCity())) {
            errors.reject("Not a valid city.");
            return;
        } else if (address.getCountry().isEmpty()) {
            errors.reject("Country must be provided.");
            return;
        } else if (address.getState().isEmpty()) {
            errors.reject("State must be provided.");
            return;
        } else if (address.getState().length() != 2) {
            errors.reject("Not a valid state.");
            return;
        } else if (address.getZipCode().isEmpty()) {
            errors.reject("Zip Code must be provided.");
            return;
        } else if (!address.getZipCode().matches(VALID_ZIP_CODE)) {
            errors.reject("Not a valid zip code.");
            return;
        }
    }
}
