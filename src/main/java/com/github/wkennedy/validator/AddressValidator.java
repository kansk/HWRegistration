package com.github.wkennedy.validator;

import com.github.wkennedy.model.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Address.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Address address = (Address) o;
    }
}
