package offer35;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author CJR
 * @create 2021-11-17-16:10
 */
public class Solution {
    public static void main(String[] args) {
        Node head = Node.initNodeList();
        System.out.println(head);
        Node newHead = copyWithoutRandom(head);
        System.out.println(newHead);
        Node copyHead = copyRandom(head, newHead);
        System.out.println(copyHead);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = copyWithoutRandom(head);
        Node node = copyRandom(head, newHead);
        return node;
    }

    public static Node copyRandom(Node head, Node newHead) {
        Node tmp1 = head;
        Node tmp2 = newHead;
        Node t1;
        Node t2;
        int time = 0;
        int time2 = 0;
        while (tmp1 != null) {
            Node random1 = tmp1.random;
            if (random1 == null) {
                tmp2.random = null;
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
                continue;
            }
            t1 = head;
            while (t1 != null) {
                time++;
                if (t1 == random1) {
                    t2 = newHead;
                    while (t2 != null) {
                        time2++;
                        if (time2 == time) {
                            tmp2.random = t2;
                        }
                        t2 = t2.next;
                    }
                }
                t1 = t1.next;
            }
            time = 0;
            time2 = 0;
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return newHead;
    }

    public static Node copyWithoutRandom(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp = head;
        Node newNode;
        Node newHead = null;
        boolean hasCreatedHead = false;
        Node pre = head;
        while (tmp != null) {
            newNode = new Node(tmp.val);
            if (hasCreatedHead) {
                pre.next = newNode;
                pre = newNode;
            } else {
                pre = newNode;
                newHead = newNode;
                hasCreatedHead = true;
            }
            tmp = tmp.next;
        }
        return newHead;
    }

}
