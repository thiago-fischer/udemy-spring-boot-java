package com.fischer.thiago.services;

import com.fischer.thiago.exceptions.PersonNotFoundException;
import com.fischer.thiago.models.Person;
import com.fischer.thiago.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(
                () -> new PersonNotFoundException("No person found with ID: " + id)
        );

    }

    public List<Person> findAll() {
        logger.info("Finding all people!");
        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repository.findById(id).orElseThrow(
                () -> new PersonNotFoundException("No person found with ID: " + id)
        );

        repository.delete(entity);
    }

    public Person update(Person personUpdate) {
        logger.info("Updating one person!");

        Person entity = repository.findById(personUpdate.getId()).orElseThrow(
                () -> new PersonNotFoundException("No person found with ID: " + personUpdate.getId())
        );

        entity.setFirstName(personUpdate.getFirstName());
        entity.setLastName(personUpdate.getLastName());
        entity.setAddress(personUpdate.getAddress());
        entity.setGender(personUpdate.getGender());

        return repository.save(entity);
    }

}
