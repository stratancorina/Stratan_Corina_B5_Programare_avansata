import java.util.List;

public class Commands {
    private final SocialNetwork socialNetwork = new SocialNetwork();

    public Commands() {
    }

    public void register(Person person) {
        person.setId(socialNetwork.getPeople().size() + 1);
        socialNetwork.addPerson(person);
    }

    public boolean login(String name, String password) {
        Person person = socialNetwork.findByName(name);

        if (person == null) {
            return false;
        }

        return person.getPassword().compareTo(password) == 0;
    }

    public void send(String name, String text) {
        Person person = socialNetwork.findByName(name);

        for (Person friend : person.getFriends()) {
            friend.addMessage(new Message(person.getName(), text));
        }
    }

    public List<Message> read(String name) {
        Person person = socialNetwork.findByName(name);

        return person.getMessages();
    }

    public boolean friend(String name, String[] friends) {
        Person person = socialNetwork.findByName(name);

        for (String name1 : friends) {
            Person friend = socialNetwork.findByName(name1);

            if (friend == null) {
                return false;
            } else {
                if (!person.getFriends().contains(friend))
                    person.addFriend(friend);

                if (!friend.getFriends().contains(person))
                    friend.addFriend(person);
            }
        }

        return true;
    }
}
