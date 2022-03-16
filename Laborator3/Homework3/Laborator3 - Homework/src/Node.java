import java.util.HashMap;
import java.util.Map;

abstract class Node implements Comparable<Node> {
    protected String name;
    protected String location;

    public Node(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", cost=" + cost +
                '}';
    }

    private Map<Node,Integer> cost = new HashMap<>();

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
    }

    @Override
    public int compareTo(Node o) {
        return this.name.compareTo(o.name);
    }
}
