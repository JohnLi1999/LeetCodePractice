package medium._0435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*  https://leetcode.com/problems/non-overlapping-intervals/
    Time complexity: O(n*log(n))
        1. Sort the intervals take O(n*log(n)) time
        2. Traverse the intervals to check overlapping takes O(n) time
        So, overall the time complexity is O(n*log(n))
    Space complexity: O(1)
        No extra space is used.
 */
public class Solution_Greedy_Better {
    public int eraseOverlapIntervals(int[][] intervals) {
//        return greedy_start_points(intervals);
        return greedy_end_points(intervals);
    }

    public int greedy_end_points(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        /* Sort intervals by end points */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        /*  Sort intervals by end points gives us a huge benefit:
                If we find two interval overlap (prev and curr), we can always remove current interval!
            This is because after sorting, previous interval's end point is always
            smaller or equal to the current interval's end point. So, we can always remove the current interval
            to save space for the future interval.
         */

        int removeCount = 0, prev = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[prev][1]) {
                /* Remove current interval if current and previous overlap */
                removeCount++;
            } else {
                /* Otherwise, update previous to current */
                prev = i;
            }
        }

        return removeCount;
    }

    public int greedy_start_points(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        /* Sort intervals by start points */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int removeCount = 0, prev = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                /*  Case 1: current and previous intervals overlap, but
                    previous's end point is smaller or equal than the end point of current
                    So we only need to increase remove count  */

                if (intervals[prev][1] > intervals[i][1]) {
                    /*  Case 2: current and previous intervals do not overlap, and
                        previous's end point is larger the end point of current.
                        So we need to increase remove count and update previous to current  */
                    prev = i;
                }

                /* Increase remove count once found overlapping */
                removeCount++;
            } else {
                /*  Case 3: current and previous intervals do not overlap,
                    so do not increase remove count and update previous to current  */
                prev = i;
            }
        }

        return removeCount;
    }
}
