package medium._0322_Coin_Change.round_2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[] {1, 2, 5}, 11)); // 3
        System.out.println(s.coinChange(new int[] {2}, 3)); // -1
        System.out.println(s.coinChange(new int[] {1}, 0)); // 0
        System.out.println(s.coinChange(new int[] {1}, 1)); // 1
        System.out.println(s.coinChange(new int[] {1}, 2)); // 2
        System.out.println(s.coinChange(new int[] {186,419,83,408}, 6249)); // 20
    }

    /*  Dynamic Programming - Bottom Up
        Time complexity: O(S * n)
            S -> amount
            n -> length of the coin array
        Space complexity: O(S)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int least = Integer.MAX_VALUE;

            for (int coin : coins) {
                int count = (i < coin) ? -1 : dp[i - coin];
                if (count != -1 && count < least) {
                    least = count;
                }
            }

            if (least == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = 1 + least;
            }
        }

        return dp[amount];
    }

//    /*  Memoization
//        Time complexity: O(S * n)
//            S -> amount
//            n -> length of the coin array
//        Space complexity: O(S)
//     */
//    private int[] coins;
//    private int[] memo;
//
//    public int coinChange(int[] coins, int amount) {
//        this.memo = new int[amount + 1];
//        this.coins = coins;
//        return memoization(amount);
//    }
//
//    public int memoization(int amount) {
//        if (amount < 0) {
//            return -1;
//        }
//        if (amount == 0) {
//            return 0;
//        }
//
//        if (memo[amount] != 0) {
//            return memo[amount];
//        }
//
//        int least = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//            int count = memoization(amount - coin);
//            if (count != -1 && count < least) {
//                least = count;
//            }
//        }
//
//        if (least == Integer.MAX_VALUE) {
//            memo[amount] = -1;
//        } else {
//            memo[amount] = 1 + least;
//        }
//
//        return memo[amount];
//    }
}
