package offer24;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author CJR
 * @create 2021-11-03-19:10


/*
剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
*/

// 用一个栈，相当于递归
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(new Solution().reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode newHead = null;
        boolean b = false;
        while (!stack.isEmpty()) {
            System.out.println("val = " + stack.peek().val);
            if (!b) {
                newHead = stack.pop();
                if (stack.isEmpty()) {
                    newHead.next = null;
                } else {
                    newHead.next = stack.peek();
                }
                b = true;
            } else {
                ListNode pop = stack.pop();
                if (stack.isEmpty()) {
                    pop.next = null;
                } else {
                    pop.next = stack.peek();
                }
            }
        }
        return newHead;
    }
}
