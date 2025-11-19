package com.fischer.thiago.v2.controllers;

import com.fischer.thiago.v2.dto.PersonDTO;
import com.fischer.thiago.v2.services.PersonServicesV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("personControllerV2")
@RequestMapping("/person/v2")
public class PersonController {

    @Autowired
    private PersonServicesV2 service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @DeleteMapping(
            value = "delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

}
