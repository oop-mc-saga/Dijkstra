package graph;

/**
 * 頂点のクラス：始点からの距離で他の頂点と比較できる
 *
 * @author tadaki
 */
public class Node implements Comparable<Node> {

    public final String label;//頂点のラベル
    private double distance;//始点からの距離

    public Node(String label) {
        this.label = label;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * 他の頂点との比較
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return (int) Math.signum(this.distance - o.distance);
    }

    @Override
    public String toString() {
        return label;
    }

}
