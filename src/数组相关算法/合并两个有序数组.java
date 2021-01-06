package 数组相关算法;

/**
 * 题目描述
 * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=190&&tqId=35185&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] A=new int[1];
        int[] B=new int[]{1};
        merge(A,0,B,1);


    }
    public static void merge(int A[], int m, int B[], int n) {
        if (A == null) {
            throw new IllegalArgumentException();
        }
        if (B == null) {
            return;
        }

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (i >= 0 &&( j < 0 || A[i] >= B[j])) {
                A[k--] = A[i--];
            } else if (j >= 0 && (i < 0 || A[i] < B[j])) {
                A[k--] = B[j--];
            }
        }
    }
}
