package graph;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * グラフの抽象クラス
 *
 * @author tadaki
 */
public abstract class Graph {

    private final Set<Node> nodes;
    //頂点を始点とする弧のリスト
    private final Map<Node, List<Arc>> node2arc;
    public final String title;

    public Graph(String title) {
        this.title = title;
        nodes = new TreeSet<>();
        node2arc = new HashMap<>();
    }

    /**
     * 頂点を追加
     *
     * @param node
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * 弧を追加
     *
     * @param from 弧の始点
     * @param to 弧の終点
     * @param length 弧の長さ
     * @param label
     */
    public void addArc(Node from, Node to, double length, String label) {
        Arc arc = new Arc(from, to, length, label);
        if (!node2arc.containsKey(from)) {
            List<Arc> arcList = new ArrayList<>();
            node2arc.put(from, arcList);
        }
        node2arc.get(from).add(arc);
    }

    /**
     * 頂点の一覧
     *
     * @return
     */
    public Set<Node> getNodes() {
        return nodes;
    }

    /**
     * 指定した頂点を始点とする弧のリスト
     *
     * @param node
     * @return
     */
    public List<Arc> getArcs(Node node) {
        return node2arc.get(node);
    }

    /**
     * 派生クラスでは、具体的なグラフを構成するメソッドを実装
     */
    abstract public void construct();
}
