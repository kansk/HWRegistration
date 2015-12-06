package com.github.wkennedy.validator;

import com.github.wkennedy.model.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by wkennedy on 12/5/15.
 */
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;


    }
}
