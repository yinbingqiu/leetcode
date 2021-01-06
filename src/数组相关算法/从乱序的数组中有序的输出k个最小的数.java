package 数组相关算法;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 从乱序的数组中有序的输出k个最小的数 {
    public static void main(String[] args) {
        int[] input = new int[] { 4,5,1,6,2,7,3,8 };
        ArrayList<Integer> list = GetLeastNumbers_Solution(input, 10);
        list.forEach(i -> System.out.println(i));

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null || input.length == 0 || k==0) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : input) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        if (queue.size() == k) {
            return new ArrayList<>(queue.stream().sorted(Integer::compareTo).collect(Collectors.toList()));
        } else {
            return new ArrayList<>();
        }
    }
}
