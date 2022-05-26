package com.example.services;

import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable {
    private Integer id;
    private String name;
    private String password;
    private Set<Person> friends = new HashSet<>();

    public Person() {
    }

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Person(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Person> getFriends() {
        return friends;
    }

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", friends=" + friends +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new NullPointerException();
        if (!(o instanceof Person person))
            throw new ClassCastException("Uncomparable objects!");

        return Integer.compare(this.friends.size(), person.friends.size());
    }
}
