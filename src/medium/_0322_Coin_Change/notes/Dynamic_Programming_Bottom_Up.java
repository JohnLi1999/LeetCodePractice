package medium._0322_Coin_Change.notes;

import java.util.Arrays;

/*  Time complexity: O(S*n)
        On each step the algorithm finds the next F(i) in n iterations,
        where 1 ≤ i ≤ S. Therefore in total the iterations are S*n.
    Space complexity: O(S)
        We use extra space for the memoization table.
 */
public class Dynamic_Programming_Bottom_Up {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}