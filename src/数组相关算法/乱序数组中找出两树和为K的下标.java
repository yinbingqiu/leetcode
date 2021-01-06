package 数组相关算法;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=190&&tqId=35361&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * <p>
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 */
public class 乱序数组中找出两树和为K的下标 {
    /**
     * 思路：首先要知道不能改变原数组的顺序，即使是要使用排序的方式来解决也要备份一份数据
     * 其二：整体的解法有两种（1）用map做映射，（2）先对备份数据排序然后挨个找
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null) {
            throw new IllegalArgumentException("参数不符合逾期");
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int ret = target - number;
            if (map.containsKey(ret)) {
                return new int[] { map.get(ret) + 1, i + 1 };
            } else {
                map.put(number, i);
            }
        }
        return null;

    }

}
