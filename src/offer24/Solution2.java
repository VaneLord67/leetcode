package offer24;

/**
 * @author CJR
 * @create 2021-11-03-19:36
 */

// 递归法
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur,ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode res = recur(cur.next,cur);
        cur.next = pre;
        return res;
    }

}
