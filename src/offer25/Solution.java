package offer25;

/**
 * @author CJR
 * @create 2021-11-03-20:02
 */

/*
剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */



public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        while (p != null) {
            cur.next = p;
            cur = cur.next;
            p = p.next;
        }
        while (q != null) {
            cur.next = q;
            cur = cur.next;
            q = q.next;
        }
        return head.next;
    }
}
