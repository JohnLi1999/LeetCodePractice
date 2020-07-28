package medium._0322_Coin_Change;

import java.util.Arrays;

/*  https://leetcode.com/problems/coin-changea
    Time complexity: O(S*n)
        On each step the algorithm finds the next F(i) in n iterations,
        where 1 ≤ i ≤ S. Therefore in total the iterations are S*n.
    Space complexity: O(S)
        We use extra space for the memoization table.
 */
public class Solution_Dynamic_Programming {
    public int coinChange_Better_Way(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (coin < dp.length) {
                dp[coin] = 1;
            }
        }

        for (int i = 0; i <= amount; i++) {
            int count = -1;

            if (dp[i] != 0) {
                continue;
            }

            for (int coin : coins) {
                int index = i - coin;
                if (index >= 0 && dp[index] != -1) {
                    count = count == -1 ? dp[index] + 1 : Math.min(count, dp[index] + 1);
                }
            }

            dp[i] = count;
        }

        return dp[amount];
    }
}
