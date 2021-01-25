package 动态规划;

public class 最最长递增子序列 {

    public int[] longestIncrementSeq(int[] arr) {
        int[] dp = new int[arr.length];
        int[] end = new int[arr.length + 1];

        int length = 1;
        dp[0] = 1;
        end[1] = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (end[length] < arr[i]) {
                end[++length] = arr[i];
                dp[i] = length;
            } else {
                int left = 0;
                int right = length;
                while (left <= right) {
                    int middle = (left + right) / 2;
                    if (end[middle] >= arr[i]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }

                end[left] = arr[i];
                dp[left] = left;
            }
        }
        int[] result = new int[length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] == length) {
                result[--length] = arr[i];
            }
        }

        return result;
    }
}
