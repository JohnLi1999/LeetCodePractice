package medium._0091_Decode_Ways.notes;

import java.util.HashMap;

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
public class Recursive_Approach_with_Memoization {
    HashMap<Integer, Integer> memo = new HashMap<>();

    private int recursiveWithMemo(int index, String str) {

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }

        // Memoization is needed since we might encounter the same sub-string.
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index+2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return recursiveWithMemo(0, s);
    }
}