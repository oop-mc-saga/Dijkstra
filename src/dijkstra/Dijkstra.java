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
 *
 * @author tadaki
 */
public class Dijkstra {

    private Map<Node, Arc> node2arc;
    private final Graph graph;

    private BinaryHeap<Node> uSet;
    private Set<Node> wSet;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public Map<Node, Double> findShortestPath(Node start) {
        graph.getNodes().stream().forEach(
                n -> {
                    n.setDistance(Double.MAX_VALUE);
                });
        start.setDistance(0.);
        node2arc = new HashMap<>();
        uSet = new BinaryHeap<>();
        uSet.put(start);
        wSet = new TreeSet<>();

        findShortestPathSub();

        Map<Node, Double> distanceMap = new TreeMap(
                (Comparator<Node>) (Node n1, Node n2)
                -> n1.label.compareTo(n2.label));
        graph.getNodes().stream().forEach(
                n -> {
                    distanceMap.put(n, n.getDistance());
                });
        return distanceMap;
    }

    private void findShortestPathSub() {
        while (!uSet.isEmpty()) {
            Node w = uSet.getMinimum();
            List<Arc> arcsFromW = graph.getArcs(w);
            if (arcsFromW != null) {
                arcsFromW.stream().forEach(
                        a -> {
                            updateSub(a);
                        });
            }
            wSet.add(w);
        }
    }

    private void updateSub(Arc a) {
        Node x = a.end;
        Node w = a.head;
        if (!wSet.contains(x)) {
            if (x.getDistance() > w.getDistance() + a.length) {
                node2arc.put(w, a);
                x.setDistance(w.getDistance() + a.length);
                if (uSet.contains(x)) {//heap内の要素の位置適正化
                    uSet.reduceValue(x);
                } else {
                    uSet.put(x);
                }
            }
        }

    }
}
