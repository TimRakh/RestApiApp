package com.timurka.boot.restapp.controllers;

import com.timurka.boot.restapp.models.Person;
import com.timurka.boot.restapp.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/allclients")
    public List<Person> getPeople() {
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id);
    }

    @GetMapping("/{id}/contacts")
    public List<String> getContactsById(@PathVariable("id") int id){
        return peopleService.getContactsbyId(id);
    }

    @GetMapping("/{id}/emails")
    public List<String> getEmailsById(@PathVariable("id") int id){
        return peopleService.getEmailsbyId(id);
    }
}
