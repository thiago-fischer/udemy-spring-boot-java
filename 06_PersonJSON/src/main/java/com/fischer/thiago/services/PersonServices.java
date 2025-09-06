package com.fischer.thiago.services;

import com.fischer.thiago.database.PersonData;
import com.fischer.thiago.exceptions.PersonNotFoundException;
import com.fischer.thiago.models.Person;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("Finding one person!");
        try {
            for (int i = 0; i < PersonData.persons.size(); i++) {
                if (PersonData.persons.get(i).getId().equals(Long.parseLong(id))) {
                    return PersonData.persons.get(i);
                }
            }
            throw new PersonNotFoundException("No person found with ID: " + id);
        } catch (NumberFormatException e) {
            throw new PersonNotFoundException("Invalid ID format: " + id);
        } catch (IndexOutOfBoundsException e) {
            throw new PersonNotFoundException("No person found with ID: " + id);
        }
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return PersonData.persons;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");

        person.setId(PersonData.counter.incrementAndGet());
        PersonData.persons.add(person);
        return person;
    }

    public Person delete(String id) {
        logger.info("Deleting one person!");
        try {
            for (Person person : PersonData.persons) {
                if (person.getId().equals(Long.parseLong(id))) {
                    PersonData.persons.remove(person);
                    return person;
                }
            }
        } catch (PersonNotFoundException e) {
            throw new PersonNotFoundException("No person found with ID: " + id);
        }
        return null;
    }

    public Person update(String id, Person personUpdate) {
        logger.info("Updating one person!");

        try {
            for (Person person : PersonData.persons) {
                if (person.getId().equals(Long.parseLong(id))) {
                    personUpdate.setId(Long.parseLong(id));
                    PersonData.persons.set(PersonData.persons.indexOf(person), personUpdate);
                    return personUpdate;
                }
            }
        } catch (PersonNotFoundException e) {
            throw new PersonNotFoundException("No person found with ID: " + id);
        }
        return null;
    }

}
