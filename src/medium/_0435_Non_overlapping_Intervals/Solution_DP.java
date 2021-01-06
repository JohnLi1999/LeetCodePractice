package medium._0435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*  https://leetcode.com/problems/non-overlapping-intervals/
    Time complexity: O(n^2)
        1. Sort the intervals take O(n*log(n)) time
        2. Nested loops to traverse dp array O(n^2) time
        So, overall the time complexity is O(n^2)
    Space complexity: O(n)
        The dp array takes O(n)
 */
public class Solution_DP {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        /*  Ideas
                1.  dp[i] will save the largest number of intervals that
                    do not overlap for the first i elements (including i)
                2.  DP_Bottom_Up state transition function
                    dp[i] = max(dp[i - 1], maxOf(dp[j]) + 1), where 0 <= j < i
         */

        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return n - dp[n - 1];
    }
}
