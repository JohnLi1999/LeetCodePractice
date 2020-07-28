package medium._0322_Coin_Change;

import java.util.Arrays;
import java.util.Collections;

public class Solution_Brute_Force {
    private int[] coins;
    private int result;

    /*  https://leetcode.com/problems/coin-change/
        Time complexity: O(S^n)
            In the worst case, complexity is exponential in the number of the coins n.
            The reason is that every coin denomination c_i could have at most (S / c_i) values.
            Therefore the number of possible combinations is:
                S/c_1 * S/c_2 * S/c_3 * ... * S/c_n = S^n / (c_1 * c_2 * c_3 * ... * c_n)
        Space complexity: O(n)
            In the worst case the maximum depth of recursion is n.
            Therefore we need O(n) space used by the system recursive stack.
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        coins = Arrays.stream(coins).boxed().
                sorted(Collections.reverseOrder()).
                mapToInt(i -> i).toArray();

        this.coins = coins;
        this.result = 0;

        backtrack(amount, 0, 0);

        return result != 0 ? result : -1;
    }

    private void backtrack(int current, int index, int count) {
        if (index == coins.length) {
            return;
        }

        for (int i = current / coins[index]; i >= 0; i--) {
            if ((current - coins[index] * i) > 0) {
                backtrack(current - coins[index] * i, index + 1, count + i);
            } else if ((current - coins[index] * i) == 0) {
                if (result == 0) {
                    result = count + i;
                } else if ((count + i) < result) {
                    result = count + i;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }
}
