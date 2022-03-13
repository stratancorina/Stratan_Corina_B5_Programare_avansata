
public class Main {

    public static void main(String[] args) {

        Network network = new Network();

        Computer computerA = new Computer("A", "00:00:5e:00:53:af" , "v1",  "192.168.56.1", 512 );
        Router routerA = new Router("A", "00:00:5e:00:53:af", "v2", "192.168.56.1");
        Switch switchA = new Switch("A", "00:00:5e:00:53:af", "v3");
        Switch switchB = new Switch("B" , "00:00:5e:00:53:af", "v4");
        Router routerB = new Router("B", "00:00:5e:00:53:af", "v5", "192.168.56.1");
        Computer computerB = new Computer("", "00:00:5e:00:53:af" , "v6",  "192.168.56.1", 256 );

        network.addNode(computerA);
        network.addNode(routerA);
        network.addNode(switchA);
        network.addNode(switchB);
        network.addNode(routerB);
        network.addNode(computerB);

        System.out.println(network);
    }
}