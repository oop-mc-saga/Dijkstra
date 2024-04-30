package examples;

import dijkstra.Dijkstra;
import graph.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Example of a graph for Dijsktra algorithm
 * 
 * @author tadaki
 */
public class Graph1 extends Graph {

    private final int n = 5;//number of nodes
    List<Node> localNodeList;

    public Graph1(String title) {
        super(title);
    }

    @Override
    public void construct() {
        localNodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node nn = new Node(String.valueOf(i));
            localNodeList.add(nn);
            addNode(nn);
        }
        connect(0, 1, 2.);
        connect(0, 2, 1.);
        connect(1, 3, 1.);
        connect(1, 4, 3.);
        connect(2, 3, 3.);
        connect(3, 4, 1.);
    }

    private void connect(int i, int j, double d) {
        String label = "(" + i + "->" + j + ")";
        addArc(localNodeList.get(i), localNodeList.get(j), d, label);
    }

    public Node getStart() {
        return localNodeList.get(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph1 graph = new Graph1("graph-1");
        graph.construct();

        Dijkstra dijkstra = new Dijkstra(graph);
        Set<Node> result = dijkstra.findShortestPath(graph.getStart());
        result.forEach(n -> {
            System.out.println("Node " + n + "->" + n.getDistance());
        });
    }

}
