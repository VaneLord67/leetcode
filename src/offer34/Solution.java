package offer34;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CJR
 * @create 2021-11-11-23:57
 */


//典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。
public class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    public void recur(TreeNode root,int tar) {
        if (root == null) return;
        path.add(root.val);
        tar = tar - root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();
    }

}
