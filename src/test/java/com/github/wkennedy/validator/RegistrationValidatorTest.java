package com.github.wkennedy.validator;

import com.github.wkennedy.model.Address;
import com.github.wkennedy.model.Person;
import com.github.wkennedy.model.Registration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * RegistrationValidator Tester.
 *
 * @author wkennedy
 * @version 1.0
 * @since <pre>Dec 6, 2015</pre>
 */
public class RegistrationValidatorTest {

    private RegistrationValidator registrationValidator;
    private Registration registration;
    private Errors errors;

    @Before
    public void before() throws Exception {
        registrationValidator = new RegistrationValidator();
        registration = new Registration();

        Person person = new Person();
        person.setFirstName("Test");
        person.setLastName("Dude");

        Address address = new Address();
        address.setAddress1("123 Sesame Street");
        address.setCity("Detroit");
        address.setCountry("US");
        address.setState("MI");
        address.setZipCode("48202");

        registration.setPerson(person);
        errors = new BeanPropertyBindingResult(registration, "registration");
    }

    /**
     * Method: supports(Class<?> aClass)
     */
    @Test
    public void testSupports() throws Exception {
        assertTrue(registrationValidator.supports(Registration.class));
    }

    /**
     * Method: validate(Object o, Errors errors)
     */
    @Test
    public void testValidate() throws Exception {
        registrationValidator.validate(registration, errors);
        assertFalse(errors.hasErrors());
    }

} 
