package offer37;

/**
 * @author CJR
 * @create 2021-11-17-20:06
 */
public class 序列化二叉树 {
    /*
剑指 Offer 37. 序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。
这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     */


    /*

//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(2);
//        TreeNode node5 = new TreeNode(4);
//        TreeNode node6 = new TreeNode(3);
//        TreeNode node7 = new TreeNode(1);
//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
//        node4.left = node6;
//        node4.right = node7;
//
//        String s = new Codec().levelOrder(node1);
//        System.out.println(s);
////        String[] strings = s.split(",");
//        System.out.println(new Codec().buildTree(s));
//        TreeNode treeNode = new Codec().buildTree(s);
//        System.out.println(new Codec().levelOrder(treeNode));
//    }
//
//    List<TreeNode> list = new ArrayList<>();
//
//    public String serialize(TreeNode root) {
//        return levelOrder(root);
//    }
//
//    public TreeNode deserialize(String data) {
//        return buildTree(data);
//    }
//
//    public String levelOrder(TreeNode root) {
//        if (root == null) return "null";
//        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
//            add(root);
//        }};
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node != null) {
//                stringBuilder.append(node.val);
//            } else {
//                stringBuilder.append("null");
//                stringBuilder.append(",");
//                continue;
//            }
//            stringBuilder.append(",");
//            if (node.left != null) queue.add(node.left);
//            else queue.add(null);
//            if (node.right != null) queue.add(node.right);
//            else queue.add(null);
//        }
//        return stringBuilder.toString();
//    }
//
//    public TreeNode buildTree(String data) {
//        String[] strings = data.split(",");
//        for (String o : strings) {
//            if (!"null".equals(o)) {
//                int integer = Integer.parseInt(o);
//                TreeNode newNode = new TreeNode(integer);
//                list.add(newNode);
//            } else {
//                list.add(null);
//            }
//        }
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            TreeNode treeNode = list.get(i);
//            if (i * 2 + 1 <= size - 1) {
//                if (treeNode != null)
//                    treeNode.left = list.get(i * 2 + 1);
//            }
//            if (i * 2 + 2 <= size - 1) {
//                if (treeNode != null)
//                    treeNode.right = list.get(i * 2 + 2);
//            }
//        }
//        return list.get(0);
//    }
     */
}
