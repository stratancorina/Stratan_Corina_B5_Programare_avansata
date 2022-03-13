import java.util.HashMap;
import java.util.Map;

abstract class Node implements Comparable<Node> {

    private String name;
    private String macAddress;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Node(String name, String macAddress, String location) {
        this.name = name;
        this.macAddress = macAddress;
        this.location = location;
    }

    private Map<Node,Integer> cost = new HashMap<>();

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}
