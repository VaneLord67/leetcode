package offer27;

/**
 * @author CJR
 * @create 2021-11-04-18:31
 */

/*
剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */


public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return recur(root);
    }

    public TreeNode recur(TreeNode A){
        if (A == null) {
            return null;
        }
        if (A.left == null && A.right == null) {
            return A;
        }
        TreeNode mirrorLeft = recur(A.left);
        TreeNode mirrorRight = recur(A.right);

        A.left = mirrorRight;
        A.right = mirrorLeft;

        return A;
    }
}
