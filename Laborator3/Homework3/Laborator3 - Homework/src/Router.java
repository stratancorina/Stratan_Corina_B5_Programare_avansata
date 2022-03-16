public class Router extends Node implements Identifiable{
    private String ipAddress;

    public Router(String name, String location, String ipAddress) {
        super(name, location);
        this.ipAddress = ipAddress;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}