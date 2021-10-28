package offer06;

/**
 * @author CJR
 * @create 2021-10-27-12:45
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        head.next = head2;
        head2.next = head3;

        System.out.println(Arrays.toString(new Solution().reversePrint(head)));
    }

    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        int[] result = new int[cnt];
        temp = head;
        for (int i = cnt-1; i >= 0; i--) {
            result[i] = temp.val;
            temp = temp.next;
        }
        return result;
    }
//    public int[] reversePrint(ListNode head) {
//        ListNode temp = head;
//        List<Integer> list = new ArrayList<>();
//        while(temp != null){
//            list.add(temp.val);
//            temp = temp.next;
//        }
//        Collections.reverse(list);
//        return list.stream().mapToInt(i -> i).toArray();
//
//    }
}
