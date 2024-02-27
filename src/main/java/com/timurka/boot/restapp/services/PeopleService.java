package com.timurka.boot.restapp.services;

import com.timurka.boot.restapp.models.Person;
import com.timurka.boot.restapp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }
    public List<String> getContactsbyId(int id){
        Optional<Person> contactsOfPerson = peopleRepository.findById(id);
        return contactsOfPerson.get().getContacts();
    }
    public List<String> getEmailsbyId(int id){
        Optional<Person> contactsOfPerson = peopleRepository.findById(id);
        return contactsOfPerson.get().getEmail();
    }
}