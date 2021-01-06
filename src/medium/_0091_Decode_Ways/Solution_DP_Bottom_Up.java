package medium._0091_Decode_Ways;

/*  https://leetcode.com/problems/decode-ways/
    Time Complexity: O(N)
        Where N is length of the string.
        We iterate the length of dp array which is N+1.
    Space Complexity:
        Normal: O(N) - We use an DP_Bottom_Up array, and O(N) is the length of the DP_Bottom_Up array.
        Optimized: O(1) - We only use three variables instead of an array
 */
public class Solution_DP_Bottom_Up {

    /*  Space Complexity: O(N)  */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            char curr = s.charAt(i - 1);

            if (curr != '0') {
                dp[i] = dp[i - 1];
            }

            char prev = s.charAt(i - 2);
            if (prev == '1' || (prev == '2' && curr <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    /*  Space Complexity: O(1)  */
    public int numDecodings_Only_DP_Variables(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int oneDigitSum = 1, twoDigitsSum = 1;

        for (int i = 1; i < s.length(); i++) {
            int totalSum = 0;
            char curr = s.charAt(i);

            if (curr != '0') {
                totalSum = oneDigitSum;
            }

            char prev = s.charAt(i - 1);
            if (prev == '1' || (prev == '2' && curr <= '6')) {
                totalSum += twoDigitsSum;
            }

            twoDigitsSum = oneDigitSum;
            oneDigitSum = totalSum;
        }

        return oneDigitSum;
    }
}
