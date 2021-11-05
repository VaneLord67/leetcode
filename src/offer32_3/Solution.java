package offer32_3;

import common.TreeNode;

import java.util.*;

/**
 * @author CJR
 * @create 2021-11-05-17:12
 */


/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(1, 2, 3, 4, null, null, 5);
//        System.out.println(Arrays.toString(TreeNode.levelOrder(root)));
        System.out.println(new Solution().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        boolean direc = false;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (direc) {
                    tmp.add(0,node.val);
                } else {
                    tmp.add(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            direc = !direc;
            res.add(tmp);
        }
        return res;
    }
}
