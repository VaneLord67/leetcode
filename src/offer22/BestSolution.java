package offer22;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJR
 * @create 2021-11-03-19:06
 */


// 双指针法
public class BestSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
