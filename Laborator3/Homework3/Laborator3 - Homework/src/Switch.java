public class Switch extends Node {
    public Switch(String name, String location) {
        super(name, location);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
