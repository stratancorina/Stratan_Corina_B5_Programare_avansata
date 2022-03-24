import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

public class TownHall {

    private final List<Intersection> intersectionList;
    private final List<Streets> streetsList;

    public TownHall(List<Intersection> intersectionList, List<Streets> streetsList) {
        this.intersectionList = intersectionList;
        this.streetsList = streetsList;
    }

    public void setCamera() {
        Graph<Intersection, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for(Intersection node : intersectionList) {
            graph.addVertex(node);
        }
        for (Streets street : streetsList) {
            graph.addEdge(street.getI1(),street.getI2());
            graph.setEdgeWeight(street.getI1(),street.getI2(), street.getLength());
        }

        PrimMinimumSpanningTree<Intersection, DefaultWeightedEdge> tree = new PrimMinimumSpanningTree<>(graph);

        System.out.println("Minimum spanning tree is ");

        for (var edge : tree.getSpanningTree().getEdges()) {
            System.out.println("(" + graph.getEdgeSource(edge).getName() + " - " + graph.getEdgeTarget(edge).getName() + ")");
        }
    }

    @Override
    public String toString() {
        return "TownHall{" +
                "intersectionList=" + intersectionList +
                ", streetsList=" + streetsList +
                '}';
    }

}
