public class Router extends Node implements Identifiable{

    public String name;
    public String macAddress;
    public String location;
    private String ipAddress;

    public Router(String name, String macAddress, String location, String ipAddress) {
        super(name, macAddress, location);
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
        this.ipAddress = ipAddress;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "Router { name= " +getName()+", macAddress= " + getMacAddress() + ", locaton= " + getLocation()+ ", ipAddress =" + getIpAddress() + "}";
    }

}