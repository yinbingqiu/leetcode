package 树的常见算法;

import java.util.ArrayList;
import java.util.LinkedList;

public class 二叉树的层序遍历 {
    /**解法一
     * 如何确定换行？
     * 标识出 当前层和下一层的分界位置
     * 将队列中的值按层一次一次遍历；即：一次性将当前队列中的当前层的元素遍历完，再在一次性遍历下一层队列元素；
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        list.offer(root);
       while (!list.isEmpty()){
           ArrayList<Integer> levelList = new ArrayList<>();
           int n = list.size();
           for (int i = 0; i < n; i++) {
               TreeNode node = list.poll();
               levelList.add(node.val);
               if (node.left != null) {
                   list.offer(node.left);
               }
               if (node.right != null) {
                   list.offer(node.right);
               }
           }

           if (!levelList.isEmpty()) {
               result.add(levelList);
           }
       }


        return result;
        // write code here
    }

    /**解法2
     * 如何确定换行？
     * 记录下"当前行的最右节点last" 和 "下一行的最右节点nlast"
     * 换行时刻：当前节点==last,然后更新last: last = nlast
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode last=root;
        TreeNode nlast=null;
        ArrayList<Integer> firstLevelList = new ArrayList<>();
        firstLevelList.add(root.val);
        result.add(firstLevelList);
        list.offer(root);
        while (!list.isEmpty()){
            ArrayList<Integer> levelList = new ArrayList<>();
            TreeNode curNode = list.poll();
            if (curNode.left !=null){
                levelList.add(curNode.left.val);
                nlast=curNode.left;
                list.offer(curNode.left);
            }

            if (curNode.right !=null){
                levelList.add(curNode.right.val);
                nlast=curNode.right;
                list.offer(curNode.right);
            }

            if (curNode == last) {
                last=nlast;
                if (! levelList.isEmpty()){
                    result.add(levelList);
                }
            }
        }
        return result;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}



