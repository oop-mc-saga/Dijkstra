package dijkstra;

import graph.*;
import binaryHeap.BinaryHeap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Dijkstra algorithm
 * 
 * @author tadaki
 */
public class Dijkstra {

    private final Graph graph;//The target graph
    private Map<Node, Arc> node2arc;//Map from node to arc

    //Set of nodes whose shortest path is once calculated but not yet determined
    private BinaryHeap<Node> uSet;
    //Set of nodes whose shortest path is determined
    private Set<Node> wSet;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public Set<Node> findShortestPath(Node start) {
        //initialize
        graph.getNodes().stream().forEach(//Set all distances to infinity
                n -> n.setDistance(Double.MAX_VALUE));
        start.setDistance(0.);
        node2arc = new HashMap<>();
        uSet = new BinaryHeap<>();
        uSet.put(start);
        wSet = new TreeSet<>();

        findShortestPathRecursive();

        // Map<Node, Double> distanceMap = new TreeMap<>(
        //         (Comparator<Node>) (Node n1, Node n2)
        //         -> n1.label.compareTo(n2.label));
        // graph.getNodes().stream().forEach(
        //         n -> distanceMap.put(n, n.getDistance()));
        // return distanceMap;
        return graph.getNodes();
    }

    private void findShortestPathRecursive() {
        while (!uSet.isEmpty()) {
            Node w = uSet.getMinimum();
            List<Arc> arcsFromW = graph.getArcs(w);
            if (arcsFromW != null) {
                arcsFromW.stream().forEach(
                        a -> updateDistance(a));
            }
            wSet.add(w);
        }
    }

    private void updateDistance(Arc a) {
        Node x = a.end;
        Node w = a.head;
        if (!wSet.contains(x)) {
            if (x.getDistance() > w.getDistance() + a.length) {
                node2arc.put(w, a);
                x.setDistance(w.getDistance() + a.length);
                if (uSet.contains(x)) {//Fixing the position in the heap
                    uSet.reduceValue(x);
                } else {
                    uSet.put(x);
                }
            }
        }

    }
}
