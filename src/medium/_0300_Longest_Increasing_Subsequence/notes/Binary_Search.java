package medium._0300_Longest_Increasing_Subsequence.notes;

import java.util.Arrays;

/*  Time complexity: O(n*log(n))
        Binary search takes log(n) time and it is called n times.
    Space complexity: O(n)
        The size of the array to store the increasing sequence is n.
 */
public class Binary_Search {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);

            if (i < 0) {
                i = -(i + 1);
            }

            dp[i] = num;

            if (i == len) {
                len++;
            }
        }

        return len;
    }
}