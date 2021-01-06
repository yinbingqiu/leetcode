//package 树的常见算法;
//
//import java.util.LinkedList;
//import java.util.Stack;
//
///**
// * 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
// * 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
// * 任意节点的左、右子树也分别为二叉查找树；
// * 没有键值相等的节点。
// */
//public class 判断树是否满足二叉搜索树 {
//
//
//    public boolean isBST(TreeNode root){
//        if (root == null){
//            return false;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.peek();
//            if (node.left!=null){
//                stack.add(node.left);
//            }
//
//            if (node.right!=null){
//
//            }
//        }
//
//    }
//
//
//    class TreeNode {
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//    }
//}
