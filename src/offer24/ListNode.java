package offer24;

/**
 * @author CJR
 * @create 2021-11-03-19:10
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode tmp = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (tmp != null) {
            stringBuilder.append(tmp.val).append("->");
            tmp = tmp.next;
        }

        return stringBuilder.toString();
    }
}
