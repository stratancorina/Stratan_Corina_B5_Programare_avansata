package com.example.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/people")
public class SocialNetworkController {
    private final List<Person> people = new ArrayList<>();

    public SocialNetworkController() {
        Person person1 = new Person(1, "corina", "cori");
        Person person2 = new Person(2, "ion", "ion");
        Person person3 = new Person(3, "andrei", "andrei");

        person1.addFriend(person2);
        person1.addFriend(person3);
        person3.addFriend(person2);

        people.add(person1);
        people.add(person2);
        people.add(person3);
    }

    @GetMapping
    public List<Person> getPeople() {
        return people;
    }

    @PostMapping
    public int createPerson(@RequestParam String name, @RequestParam String password) {
        int id = 1 + people.size();
        people.add(new Person(name, password));
        return id;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return people.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable int id, @RequestParam String name) {
        Person person = findById(id);

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);

        return new ResponseEntity<>(
                "Person updated successfully", HttpStatus.OK);
    }

    private Person findById(int id) {
        for (Person person : people) {
            if (person.getId() == id)
                return person;
        }

        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = findById(id);

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        people.remove(person);

        return new ResponseEntity<>(
                "Person removed", HttpStatus.OK);
    }

    @GetMapping("/popular/{k}")
    public List<Person> getPopularPeople(@PathVariable int k) {
        Collections.sort(people);
        List<Person> popularPeople = new ArrayList<>();

        int length = people.size() - 1;
        for (int i = 0; i < k; i++)
            popularPeople.add(people.get(length - i));

        return popularPeople;
    }

    @PatchMapping("/{id}/relationship/{name}")
    public ResponseEntity<String> insertRelationship(@PathVariable int id, @PathVariable String name) {
        Person person = findById(id);
        Person friend = findByName(name);

        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND);
        } else if (friend == null) {
            return new ResponseEntity<>(
                    "Friend not found", HttpStatus.NOT_FOUND);
        } else {
            person.addFriend(friend);
            friend.addFriend(person);

            return new ResponseEntity<>(
                    "Friend added succesfully", HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/relationship")
    public Set<Person> readRelationship(@PathVariable int id) {
        Person person = findById(id);

        if (person == null) {
            return null;
        } else
            return person.getFriends();
    }

    private Person findByName(String name) {
        for (Person person : people) {
            if (person.getName().compareTo(name) == 0)
                return person;
        }
        return null;
    }
}
