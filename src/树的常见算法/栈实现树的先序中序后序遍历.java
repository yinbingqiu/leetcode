package 树的常见算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class 栈实现树的先序中序后序遍历 {
    public static final Stack<TreeNode> stack=new Stack<>();
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        if (root==null){
            return null;
        }


        List<Integer> preList=new ArrayList<>();
        preOrderTraversal(root,preList);

        List<Integer> middleList=new ArrayList<>();
        middleOrderTraversal(root,middleList);

        List<Integer> afterList=new ArrayList<>();
        afterOrderTraveral(root,afterList);
        int[][] numbers = new int[3][];
        numbers[0] = new int[afterList.size()];
        numbers[1] = new int[afterList.size()];
        numbers[2] = new int[afterList.size()];
        IntStream.range(0,preList.size()).forEach(i->numbers[0][i]=preList.get(i));
        IntStream.range(0,middleList.size()).forEach(i->numbers[1][i]=middleList.get(i));
        IntStream.range(0,afterList.size()).forEach(i->numbers[2][i]=afterList.get(i));
        return numbers;

    }

    private void afterOrderTraveral(TreeNode root, List<Integer> afterList) {
        TreeNode lastVisit=null;

        while (root !=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }

            root = stack.peek();

            if (root.right == null || !stack.isEmpty()){
                stack.pop();
                afterList.add(root.val);
                lastVisit = root;
                root =null;
            }else {
                root = root.right;
            }
        }
    }

    private void middleOrderTraversal(TreeNode root, List<Integer> middleList) {
        while (root != null|| !stack.isEmpty() ){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }


            if (!stack.isEmpty()){
                root = stack.pop();
                middleList.add(root.val);
                root=root.right;
            }
        }
    }








    /**
     * 先序遍历
     * @param root
     * @param preList
     */
    private void preOrderTraversal(TreeNode root, List<Integer> preList) {
        while (root !=null||!stack.isEmpty()){
            //遍历左子树到底
            while ( root !=null){
                stack.push(root);
                preList.add(root.val);
                root = root.left;
            }

            //开始遍历右子树
            if (!stack.isEmpty()){
                root = stack.pop();
                root=root.right;
            }
        }
    }



    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

}
