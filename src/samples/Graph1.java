package samples;

import dijkstra.Dijkstra;
import graph.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tadaki
 */
public class Graph1 extends Graph {

    private final int n = 5;
List<Node> nodes;
    public Graph1(String title) {
        super(title);
    }

    @Override
    public void construct() {
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node nn = new Node(String.valueOf(i));
            nodes.add(nn);
            this.addNode(nn);
        }
        addArc(nodes.get(0), nodes.get(1), 2., "(0->1)");
        addArc(nodes.get(0), nodes.get(2), 1., "(0->2)");
        addArc(nodes.get(1), nodes.get(3), 1., "(1->3)");
        addArc(nodes.get(1), nodes.get(4), 3., "(1->4)");
        addArc(nodes.get(2), nodes.get(3), 3., "(2->3)");
        addArc(nodes.get(3), nodes.get(4), 1., "(3->4)");
    }

    public Node getStart() {
        return nodes.get(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph1 graph = new Graph1("graph-1");
        graph.construct();
        Dijkstra dijkstra = new Dijkstra(graph);
        Map<Node, Double> result = dijkstra.findShortestPath(graph.getStart());
        result.keySet().forEach(n -> {
            System.out.println(n + "->" + result.get(n));
        });
    }

}
