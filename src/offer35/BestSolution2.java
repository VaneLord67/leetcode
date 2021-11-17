package offer35;

/**
 * @author CJR
 * @create 2021-11-17-17:12
 */

//拼接
//时间复杂度O(N)，三轮遍历链表；空间复杂度O(1)
public class BestSolution2 {

    //构造如“原节点1->新节点1->原节点2->新节点2”这样的链表，就可以知道random如何赋值了
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //拆分两链表
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }
}
