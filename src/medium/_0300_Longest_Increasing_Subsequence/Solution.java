package medium._0300_Longest_Increasing_Subsequence;

public class Solution {
    /*  https://leetcode.com/problems/longest-increasing-subsequence/
        Time Complexity: O(n^2)
            We used two nested loops
        Space Complexity: O(1)
            Constant space is used
     */
    public int lengthOfLIS(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            /*  If the length of the unchecked part in the array is less than maximum length
                we no longer need to check them  */
            if (maxLen >= (nums.length - i)) {
                break;
            }

            // Track the current largest number and current length
            int curr = nums[i];
            int len = 1;

            // Traverse the rest array
            for (int j = i + 1; j < nums.length; j++) {
                // Special case for the last position in the array
                if (j == nums.length - 1) {
                    /*  If the last number is larger than the current maximum number in the sequence,
                        We need to include it and increase the length  */
                    if (nums[j] > curr) {
                        len++;
                    }
                    continue;
                }

                /*  1.  The first requirement for to a number into the increasing sequence is that
                        it should be larger than the current maximum number in the sequence
                    2.  Then we have two cases:
                        2.1. current number is smaller than the next number in the array
                        2.2. current number is larger than the next number in the array, BUT
                             the current maximum number in the increasing sequence is larger than or equal to
                             the next number in the array
                 */
                if (nums[j] > curr && (nums[j] < nums[j + 1] || curr >= nums[j + 1])) {
                    /*  If the number matches all the requirements, we will increase the length
                        of the increasing sequence by 1, and update the current maximum number in the sequence  */
                    len++;
                    curr = nums[j];
                }
            }

            // Update maximum length
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}
