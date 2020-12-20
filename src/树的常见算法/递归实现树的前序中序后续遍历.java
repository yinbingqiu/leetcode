package 树的常见算法;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class 递归实现树的前序中序后续遍历 {

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
        if (root == null){
            return;
        }

        afterOrderTraveral(root.left,afterList);
        afterOrderTraveral(root.right,afterList);
        afterList.add(root.val);
    }

    private void middleOrderTraversal(TreeNode root, List<Integer> middleList) {
        if (root ==null){
            return;
        }

        middleOrderTraversal(root.left,middleList);
        middleList.add(root.val);
        middleOrderTraversal(root.right,middleList);
    }








    /**
     * 先序遍历
     * @param root
     * @param preList
     */
    private void preOrderTraversal(TreeNode root, List<Integer> preList) {
        if (root==null){
            return;
        }

        preList.add(root.val);
        preOrderTraversal(root.left,preList);
        preOrderTraversal(root.right,preList);
    }



    public class TreeNode {
       int val = 0;
       TreeNode left = null;
       TreeNode right = null;
     }

}
