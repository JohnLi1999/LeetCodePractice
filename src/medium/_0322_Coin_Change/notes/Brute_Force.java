package medium._0322_Coin_Change.notes;

// Time Limit Exceeded
/*  Time complexity: O(S^n)
        In the worst case, complexity is exponential in the number of the coins n.
        The reason is that every coin denomination c_i could have at most (S / c_i) values.
        Therefore the number of possible combinations is:
            S/c_1 * S/c_2 * S/c_3 * ... * S/c_n = S^n / (c_1 * c_2 * c_3 * ... * c_n)
    Space complexity: O(n)
        In the worst case the maximum depth of recursion is n.
        Therefore we need O(n) space used by the system recursive stack.
 */
public class Brute_Force {
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount/coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }
}

