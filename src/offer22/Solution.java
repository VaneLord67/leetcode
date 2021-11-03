package offer22;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJR
 * @create 2021-11-03-18:55
 */

/*
剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */


// 定长为k的队列
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            if (queue.size() < k) {
                queue.add(tmp);
            } else {
                queue.poll();
                queue.add(tmp);
            }
            tmp = tmp.next;
        }
        return queue.poll();
    }
}
