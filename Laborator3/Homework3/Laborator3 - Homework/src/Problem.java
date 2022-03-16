import java.util.List;
import java.util.Map;

public class Problem {
    private final List<Node> nodes;
    int[][] matrix;

    public Problem(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void setMatrix() {
        matrix = new int[nodes.size() + 1][nodes.size() + 1];

        for (int i = 1; i <= nodes.size(); i++)
            for (int j = 1; j <= nodes.size(); j++)
                matrix[i][j] = 999999999;

        for (int i = 1; i < nodes.size(); i++)
            matrix[i][i] = 0;

        for (Node node : nodes) {
            Map<Node, Integer> cost = node.getCost();

            for (Map.Entry<Node, Integer> map : cost.entrySet()) {
                int i = node.getLocation().charAt(1) - 48;
                int j = map.getKey().getLocation().charAt(1) - 48;

                matrix[i][j] = map.getValue();
                matrix[j][i] = map.getValue();
            }
        }
    }

    public void algorithm() {
        for (int k = 1; k <= nodes.size(); k++) {
            for (int i = 1; i <= nodes.size(); i++) {
                for (int j = 1; j <= nodes.size(); j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
    }

    public int cost(Node n1, Node n2) {
        int i = n1.getLocation().charAt(1) - 48;
        int j = n2.getLocation().charAt(1) - 48;

        return matrix[i][j];
    }
}
