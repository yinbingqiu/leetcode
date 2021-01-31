package 动态规划;

import java.util.Arrays;

public class 筹零钱 {
    /**
     * 解法：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
     * 原题：https://leetcode-cn.com/problems/coin-change/
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i > coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
