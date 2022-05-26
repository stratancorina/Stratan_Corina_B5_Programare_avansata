import java.util.ArrayList;
import java.util.List;

public class Person {
    private Integer id;
    private String name;
    private String password;
    private final List<Person> friends = new ArrayList<>();
    private final List<Message> messages = new ArrayList<>();

    public Person(String name, String password) {
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

    public List<Person> getFriends() {
        return friends;
    }

    public void addFriend(Person person) {
        friends.add(person);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.add(message);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", messages=" + messages +
                '}';
    }
}
