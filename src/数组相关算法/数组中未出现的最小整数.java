package 数组相关算法;

public class 数组中未出现的最小整数 {

    public static void main(String[] args) {
        int[] nums=new int[]{-1,5,1,2,4};
        System.out.println(minNumberdisappered(nums));
    }

    /**
     *这道题未给的条件太多，下面的解法只适用于：只有一个正整数不存在，并且只有一个元素为负数或者0
     * 满足上面的条件时 那么缺失的数一定1-arr.length+1区间内
     * return the min number
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int minNumberdisappered (int[] arr) {
        // write code here
        int num = 0;
        for (int a : arr) {
            if (a > 0) {
                num ^= a; // 0 ^ 1 ^ 1 ^ 2 ^ 2 = 0, 0 ^ 1 ^ 2 ^ 2 = 1
            }
        }
        for (int i = 1; i <= arr.length; ++i) {
            num ^= i; // 如果某个数不存在， num将不为0
        }
        return num == 0? arr.length + 1 : num;
    }
}
