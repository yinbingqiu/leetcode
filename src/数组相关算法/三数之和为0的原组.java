package 数组相关算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, 0, 10) (-10, -10, 20)
 * https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=190&&tqId=35196&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class 三数之和为0的原组 {
    public static void main(String[] args) {
        int[] num=new int[]{1,-1,-1,0};
        threeSum(num);

    }

    /**
     * 解题思路：先对数组排序，然后遍历先选则第一个数i,再选则第二、三个数head、tail
     * 数组中是有相同数的，要注意处理去重逻辑
     * @param num
     * @return
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            int head = i + 1;
            int tail = num.length - 1;

            while (head < tail) {
                int sum = num[i] + num[head] + num[tail];
                if (sum > 0) {
                    tail--;
                } else if (sum < 0) {
                    head++;
                } else {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(num[i]);
                    tmp.add(num[head]);
                    tmp.add(num[tail]);
                    list.add(tmp);
                    // head 去重
                    while (head + 1 < tail && num[head + 1] == num[head]) {
                        head++;
                    }
                    // tail 去重
                    while (tail - 1 > head && num[tail - 1] == num[head]) {
                        tail--;
                    }
                    head++;
                }
            }


            while (i < num.length - 2 && num[i + 1] == num[i]) {
                i++;
            }
        }
        return list;
    }
}
