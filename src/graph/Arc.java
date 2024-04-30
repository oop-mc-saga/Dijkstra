package graph;

/**
 * 弧のクラス
 *
 * @author tadaki
 */
public class Arc {

    public final Node head;//始点
    public final Node end;//終点
    public final double length;//長さ
    public final String label;

    public Arc(Node head, Node end, double length, String label) {
        this.head = head;
        this.end = end;
        this.length = length;
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

}
