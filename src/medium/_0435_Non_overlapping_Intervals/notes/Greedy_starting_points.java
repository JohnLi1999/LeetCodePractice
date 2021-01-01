package medium._0435_Non_overlapping_Intervals.notes;

import java.util.Arrays;
import java.util.Comparator;

/*  https://leetcode.com/problems/non-overlapping-intervals/
    Time complexity: O(n*log(n))
        Sorting takes O(n*log(n)) time
    Space complexity: O(1)
        No extra space is used.
 */
public class Greedy_starting_points {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // Should be for starting point
             return a[0] - b[0];
//            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1], prev = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}