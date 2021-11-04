package offer28;

import common.TreeNode;

/**
 * @author CJR
 * @create 2021-11-04-23:36
 */
public class BestSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left,right.right)
                && recur(left.right,right.left);
    }
}
