package com.github.wkennedy.controller;

import com.github.wkennedy.entity.AddressEntity;
import com.github.wkennedy.entity.PersonEntity;
import com.github.wkennedy.model.Address;
import com.github.wkennedy.model.Person;
import com.github.wkennedy.model.Registration;
import com.github.wkennedy.repository.AddressRepository;
import com.github.wkennedy.repository.PersonRepository;
import com.github.wkennedy.validator.RegistrationValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new RegistrationValidator());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveRegistration(@Valid @RequestBody Registration registration) {
        AddressEntity addressEntity = modelMapper.map(registration.getAddress(), AddressEntity.class);
        addressEntity.setCreateDate(new Date());
        addressRepository.save(addressEntity);

        PersonEntity personEntity = modelMapper.map(registration.getPerson(), PersonEntity.class);
        personEntity.setCreateDate(new Date());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Registration> getRegistrations() {
        Iterable<PersonEntity> personEntities = personRepository.findAll();
        List<Registration> registrations = new ArrayList<>();
        for (PersonEntity personEntity : personEntities) {
            Registration registration = new Registration();
            Person person = modelMapper.map(personEntity, Person.class);
            registration.setPerson(person);
            Address address = modelMapper.map(personEntity.getAddress(), Address.class);
            registration.setAddress(address);
            registrations.add(registration);
        }

        return registrations;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteRegistrations() {
        personRepository.deleteAll();
    }

}
