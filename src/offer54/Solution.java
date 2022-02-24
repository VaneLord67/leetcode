package offer54;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author CJR
 * @create 2022-02-25-1:01
 */
public class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        Collections.reverse(list);
        return list.get(k - 1);
    }

    public void recur(TreeNode root, List<Integer> list) {
        if (root == null) return;
        recur(root.left, list);
        list.add(root.val);
        recur(root.right, list);
    }
}
