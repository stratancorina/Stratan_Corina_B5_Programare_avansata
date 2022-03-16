import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {

    private List<Node> nodes = new ArrayList<>();

    public Network() {
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        Collections.sort(nodes);
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

    public int sortingList(Node n1, Node n2) {
        Identifiable i1 = (Identifiable) n1;
        Identifiable i2 = (Identifiable) n2;

        return i1.getIpAddress().compareTo(i2.getIpAddress());
    }

    public List<Node> areIdentifiable() {
        List<Node> list = new ArrayList<>();

        for (Node node : nodes) {
            if (node instanceof Identifiable) {
                list.add(node);
            }
        }

        Collections.sort(list, this::sortingList);

        return list;
    }
}
