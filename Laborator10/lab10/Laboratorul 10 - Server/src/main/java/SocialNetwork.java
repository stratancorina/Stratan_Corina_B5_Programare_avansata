import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Person> people = new ArrayList<>();

    public SocialNetwork() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person findByName(String name) {
        for (Person person : people) {
            if (person.getName().compareTo(name) == 0)
                return person;
        }
        return null;
    }
}
