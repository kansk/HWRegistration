package com.github.wkennedy.service;

import com.github.wkennedy.entity.AddressEntity;
import com.github.wkennedy.entity.PersonEntity;
import com.github.wkennedy.model.Address;
import com.github.wkennedy.model.Person;
import com.github.wkennedy.model.Registration;
import com.github.wkennedy.repository.AddressRepository;
import com.github.wkennedy.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveRegistration(Registration registration) {
        AddressEntity addressEntity = modelMapper.map(registration.getAddress(), AddressEntity.class);
        addressEntity.setCreateDate(new Date());
        addressRepository.save(addressEntity);

        PersonEntity personEntity = modelMapper.map(registration.getPerson(), PersonEntity.class);
        personEntity.setCreateDate(new Date());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
    }

    @Override
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

    @Override
    public void deleteRegistrations() {
        personRepository.deleteAll();
    }

}
