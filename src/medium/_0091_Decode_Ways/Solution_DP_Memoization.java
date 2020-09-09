package medium._0091_Decode_Ways;

import java.util.HashMap;
import java.util.Map;

/*  https://leetcode.com/problems/decode-ways/
    Time Complexity: O(N)
        Where N is length of the string.
        Memoization helps in pruning the recursion tree and
        hence decoding for an index only once.
        Thus this solution is linear time complexity.
    Space Complexity: O(N)
        The dictionary used for memoization would take the space equal to the length of the string.
        There would be an entry for each index value.
        The recursion stack would also be equal to the length of the string.
 */
public class Solution_DP_Memoization {
    private Map<String, Integer> map;

    public int numDecodings(String s) {
        map = new HashMap<>();
        return decode(s);
    }

    private int decode(String s) {
        if (s.length() <= 0) {
            return 1;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        int countOneDigitWays = 0;
        int countTwoDigitsWays = 0;

        char curr = s.charAt(0);
        if (curr != '0') {
            countOneDigitWays = decode(s.substring(1));
        }

        if (s.length() > 1) {
            char next = s.charAt(1);
            if (curr == '1' || (curr == '2' && next <= '6')) {
                countTwoDigitsWays = decode(s.substring(2));
            }
        }

        int totalCount = countOneDigitWays + countTwoDigitsWays;
        map.put(s, totalCount);
        return totalCount;
    }
}
