package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CJR
 * @create 2021-11-04-23:35
 */

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode(int x) {
        this.val = x;
    }
    public TreeNode(int x,TreeNode left,TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    private static ArrayList<TreeNode> list = new ArrayList<>();

    public static TreeNode buildTree(Object... objects) {
        for (Object o : objects) {
            if (o instanceof Integer) {
                Integer integer = (Integer) o;
                TreeNode newNode = new TreeNode(integer);
                list.add(newNode);
            } else {
                list.add(null);
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = list.get(i);
            if (i * 2 + 1 <= size - 1) {
                treeNode.left = list.get(i * 2 + 1);
            }
            if (i * 2 + 2 <= size - 1) {
                treeNode.right = list.get(i * 2 + 2);
            }
        }
        return list.get(0);
    }

    public static int[] levelOrder(TreeNode root) {
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
