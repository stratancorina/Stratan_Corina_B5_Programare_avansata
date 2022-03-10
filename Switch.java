public class Switch extends Node {


    public String name;

    public Switch(String name, String macAddress, String location) {
        super(name, macAddress, location);
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
    }

    public String macAddress;
    public String location;



    @Override
    public String toString() {
        return "Switch {" +
                ",name=" + getName() +
                ",macAddress=" + getMacAddress() +
                ",location=" + getLocation() +
                '}'       ;
    }

}
