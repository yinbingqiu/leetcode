package 数组相关算法;

/**
 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * 假设数组中不存在重复项。
 */
public class 在转动过得数组中寻找目标值 {

    /**
     * 解题思路1：O(n) 全部遍历一次直接得出下标即可
     * 解题思路2：转动数组的性质，head->mid->tail ;head->mid 是增大，tail->mid 是减小，
     * 只需要先判断下target载那个区间再按照区间数据的性质直接找就行
     *
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int head = 0;
        int tail = A.length - 1;
        while (head <= tail) {
            // 数据可能在mid->tail 区间
            while (head <= tail && target < A[head]) {
                if (target == A[tail]) {
                    return tail;
                } else if (target < A[tail]) {
                    tail--;
                } else {
                    return -1;
                }
                if (tail >= 0 && A[tail] > A[tail + 1]) {
                    return -1;
                }
            }
            // 数据可能在head->mid区间
            while (head <= tail && target >= A[head]) {
                if (target == A[head]) {
                    return head;
                } else if (target > A[head]) {
                    head++;
                } else {
                    return -1;
                }
                if (head <= A.length - 1 && A[head] < A[head - 1]) {
                    return -1;
                }
            }

        }

        return -1;
    }
}
