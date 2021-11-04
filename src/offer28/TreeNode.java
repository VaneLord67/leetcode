package offer28;

import java.util.ArrayList;

/**
 * @author CJR
 * @create 2021-11-04-23:01
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int x) {
        this.val = x;
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
}
