package com.github.wkennedy.controller;

import com.github.wkennedy.entity.AddressEntity;
import com.github.wkennedy.entity.PersonEntity;
import com.github.wkennedy.model.Registration;
import com.github.wkennedy.repository.AddressRepository;
import com.github.wkennedy.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void saveRegistration(@RequestBody Registration registration) {
        AddressEntity addressEntity = modelMapper.map(registration.getAddress(), AddressEntity.class);
        addressRepository.save(addressEntity);

        PersonEntity personEntity = modelMapper.map(registration.getPerson(), PersonEntity.class);
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
    }
}
