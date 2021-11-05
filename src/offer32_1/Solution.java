package offer32_1;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJR
 * @create 2021-11-05-16:36
 */

/*
剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        ArrayList<Integer> integers = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            integers.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return integers.stream().mapToInt(x -> x).toArray();
    }

}
