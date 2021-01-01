package medium._0435_Non_overlapping_Intervals.notes;

import java.util.Arrays;
import java.util.Comparator;

/*  https://leetcode.com/problems/non-overlapping-intervals/
    Time complexity: O(2^n)
        Total possible number of Combinations of subsets are 2^n
    Space complexity: O(n)
        Depth of recursion is n
 */
public class Brute_Force {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new myComparator());
        return erase_Overlap_Intervals(-1, 0, intervals);
    }
    public int erase_Overlap_Intervals(int prev, int curr, int[][] intervals) {
        if (curr == intervals.length) {
            return 0;
        }
        int taken = Integer.MAX_VALUE, nottaken;
        if (prev == -1 || intervals[prev][1] <= intervals[curr][0]) {
            taken = erase_Overlap_Intervals(curr, curr + 1, intervals);
        }
        nottaken = erase_Overlap_Intervals(prev, curr + 1, intervals) + 1;
        return Math.min(taken, nottaken);
    }
}
