package 树的常见算法;

import java.util.Stack;

public class 数的深度优先遍历 {

    public void dfs(Tree root) {
        if (root == null) {
            return;
        }
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    static class Tree {
        int data;
        Tree left;
        Tree right;

        public Tree(int data) {
            this.data = data;
        }
    }
}
