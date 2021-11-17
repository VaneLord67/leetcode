package offer35;

/**
 * @author CJR
 * @create 2021-11-17-16:10
 */

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void main(String[] args) {
        Node head = initNodeList();
//        System.out.println(head.toString());
//        System.out.println(Solution.getListNum(head));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int time = 0;
        Node tmp = this;
        Node timeTmp;
        while (tmp != null) {
            stringBuilder.append("[");
            stringBuilder.append(tmp.val);
            stringBuilder.append(",");
            if (tmp.random == null) {
                stringBuilder.append("null");
            } else {
                timeTmp = this;
                while (timeTmp != null && timeTmp != tmp.random) {
                    time++;
                    timeTmp = timeTmp.next;
                }
                stringBuilder.append(time);
                time = 0;
//                stringBuilder.append(System.identityHashCode(tmp.random));
            }
            stringBuilder.append("]");
            stringBuilder.append("->");
            tmp = tmp.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public static Node initNodeList() {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        return node1;
    }
}
