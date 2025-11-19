package com.fischer.thiago.v1.services;

import com.fischer.thiago.v1.dto.PersonDTO;
import com.fischer.thiago.v1.exceptions.PersonNotFoundException;
import static com.fischer.thiago.v1.mapper.ObjectMapper.parseObject;
import static com.fischer.thiago.v1.mapper.ObjectMapper.parseListObjects;
import com.fischer.thiago.v1.models.Person;
import com.fischer.thiago.v1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;


@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        return parseObject(
                repository.findById(id).orElseThrow(
                        () -> new PersonNotFoundException("No person found with ID: " + id)
                ),
                PersonDTO.class
        );

    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all people!");
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");
        Person entity= repository.save(parseObject(person, Person.class));
        return parseObject(entity, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repository.findById(id).orElseThrow(
                () -> new PersonNotFoundException("No person found with ID: " + id)
        );

        repository.delete(entity);
    }

    public PersonDTO update(PersonDTO personUpdate) {
        logger.info("Updating one person!");

        Person entity = repository.findById(personUpdate.getId()).orElseThrow(
                () -> new PersonNotFoundException("No person found with ID: " + personUpdate.getId())
        );

        entity.setFirstName(personUpdate.getFirstName());
        entity.setLastName(personUpdate.getLastName());
        entity.setAddress(personUpdate.getAddress());
        entity.setGender(personUpdate.getGender());

        repository.save(entity);

        return parseObject(entity, PersonDTO.class);
    }

}
