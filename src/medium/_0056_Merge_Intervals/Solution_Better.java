package medium._0056_Merge_Intervals;

import java.util.*;

/*  https://leetcode.com/problems/merge-intervals/
    Time complexity: O(n*log(n))
        1. Sort the intervals array need O(n*log(n)) time
        2. Traverse the intervals array takes O(n) time
        Overall the time complexity is O(n*log(n))
    Space complexity: O(n)
        In the worst case, no intervals are overlapping, and
        the the result list will store will all the intervals. Thus, the space complexity is O(n).
 */
public class Solution_Better {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{}};
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] previous = null;

        for (int[] current : intervals) {
            if (previous == null || previous[1] < current[0]) {
                result.add(current);
                previous = current;
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
