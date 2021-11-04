package offer28;

/**
 * @author CJR
 * @create 2021-11-04-23:01
 */

/*
剑指 Offer 28. 对称的二叉树
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(1, 2, 2, null, 3, null, 3);

        StringBuilder stringBuilder = new StringBuilder();
        String s1 = printTree(root, stringBuilder);
        TreeNode mirrorTree = new Solution().mirrorTree(root);
        stringBuilder = new StringBuilder();
        String s2 = printTree(mirrorTree, stringBuilder);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String s1 = printTree(root, stringBuilder);
        TreeNode mirrorTree = mirrorTree(root);
        stringBuilder = new StringBuilder();
        String s2 = printTree(mirrorTree, stringBuilder);
        return s1.equals(s2);
    }

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

    public static String printTree(TreeNode root,StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("null");
            stringBuilder.append(",");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        printTree(root.left,stringBuilder);
        printTree(root.right,stringBuilder);
        return stringBuilder.toString();
    }
}
