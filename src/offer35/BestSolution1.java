package offer35;

import java.util.HashMap;

/**
 * @author CJR
 * @create 2021-11-17-17:07
 */
//哈希表
//时间复杂度O(N)，两轮遍历链表；空间复杂度O(N)，哈希表
public class BestSolution1 {
    //哈希表，原节点为key，新节点为value，把原节点和新节点绑定起来，然后再进行next和random的赋值
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
