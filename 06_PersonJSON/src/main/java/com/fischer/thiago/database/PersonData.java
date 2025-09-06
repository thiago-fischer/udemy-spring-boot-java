package com.fischer.thiago.database;

import com.fischer.thiago.models.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


public class PersonData {

    public static final AtomicLong counter = new AtomicLong();
    public static List<Person> persons = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Person mockPerson = mockPerson(i);
            persons.add(mockPerson);
        }
    }

    private static Person mockPerson(int i) {
        Random random = new Random();

        List<String> names = List.of("Thiago", "Ana", "Maria", "João", "Pedro", "Lucas", "Mariana", "Beatriz");
        List<String> lastNames = List.of("Fischer", "Silva", "Souza", "Oliveira", "Pereira", "Lima", "Gomes");
        int namesIndex = random.nextInt(names.size());
        int lastNamesIndex = random.nextInt(lastNames.size());

        Person person = new Person();
        person.setId(PersonData.counter.incrementAndGet());
        person.setFirstName(names.get(namesIndex));
        person.setLastName(lastNames.get(lastNamesIndex));
        person.setAddress("Some address in Brasil " + i);
        person.setGender(List.of("Male", "Female").get(random.nextInt(2)));

        return person;
    }
}
