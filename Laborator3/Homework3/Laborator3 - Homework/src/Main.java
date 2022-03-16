import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Network network = new Network();

        Computer computerA = new Computer("Computer A", "v1", "192.168.56.3", 512);
        Router routerA = new Router("Router A", "v2", "192.168.56.2");
        Switch switchA = new Switch("Switch A", "v3");
        Switch switchB = new Switch("Switch B", "v4");
        Router routerB = new Router("Router B", "v5", "192.168.56.1");
        Computer computerB = new Computer("Computer B", "v6", "192.168.56.1", 256);

        network.addNode(computerA);
        network.addNode(routerA);
        network.addNode(switchA);
        network.addNode(switchB);
        network.addNode(routerB);
        network.addNode(computerB);

        System.out.println(network);

        computerA.setCost(routerA, 10);
        computerA.setCost(switchA, 50);
        routerA.setCost(switchA, 20);
        routerA.setCost(switchB, 20);
        routerA.setCost(routerB, 20);
        switchA.setCost(switchB, 10);
        switchB.setCost(routerB, 30);
        switchB.setCost(computerB, 10);
        routerB.setCost(computerB, 20);

        for (Node node : network.getNodes()) {
            Map<Node, Integer> cost = node.getCost();

            for (Map.Entry<Node, Integer> map : cost.entrySet()) {
                System.out.println(node.getLocation() + " to " + map.getKey().getLocation() + " cost is " + map.getValue());
            }
        }

        System.out.println(network.areIdentifiable());

        Problem problem = new Problem(network.getNodes());
        problem.setMatrix();
        problem.algorithm();

        for (Node node1 : network.getNodes()) {
            for (Node node2 : network.getNodes()) {
                System.out.println(node1.getLocation() + " to " + node2.getLocation() + " cost is " + problem.cost(node1, node2));

            }
        }
    }
}