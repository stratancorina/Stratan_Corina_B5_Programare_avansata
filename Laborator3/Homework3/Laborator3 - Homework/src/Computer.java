public class Computer extends Node implements Identifiable, Storage{
    private String ipAddress;
    private int storageCapacityGB;

    public Computer(String name, String location, String ipAddress, int storageCapacityGB) {
        super(name, location);
        this.ipAddress = ipAddress;
        this.storageCapacityGB = storageCapacityGB;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public int getStorageCapacityGB() {
        return storageCapacityGB;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "ipAddress='" + ipAddress + '\'' +
                ", storageCapacityGB=" + storageCapacityGB +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}