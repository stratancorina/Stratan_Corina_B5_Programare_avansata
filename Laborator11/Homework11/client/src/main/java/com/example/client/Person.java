package com.example.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class Person {
    public Integer id;

    public String name;

    public Set<Person> friends = new HashSet<>();

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
