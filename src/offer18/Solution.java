package offer18;

/**
 * @author CJR
 * @create 2021-10-30-16:53
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp = head;
        if(head.val == val){
            return head.next;
        }
        while(tmp != null){
            if(tmp.next != null && tmp.next.val == val){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
        }
        return head;
    }
}
