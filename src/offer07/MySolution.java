package offer07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CJR
 * @create 2021-10-27-16:40
 */
public class MySolution {
    private Map<Integer,Integer> indexMap = new HashMap();

    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left > preorder_right){
            return null;
        }

        int inorder_root = indexMap.get(preorder[preorder_left]);
        TreeNode treeNode = new TreeNode(preorder[preorder_left]);
        int size_left_subtree = inorder_root - inorder_left;
        treeNode.left = myBuildTree(preorder,inorder,preorder_left + 1,preorder_left + size_left_subtree,inorder_left,inorder_root - 1);
        treeNode.right = myBuildTree(preorder,inorder,preorder_left + size_left_subtree + 1,preorder_right,inorder_root + 1,inorder_right);

        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }

        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
}
