package medium._0056_Merge_Intervals;

import java.util.*;

/*  https://leetcode.com/problems/merge-intervals/
    Time complexity: O(n*log(n))
        1. Sort the intervals array need O(n*log(n)) time
        2. Both add elements into and pull elements out from the stack needs O(n) time
        Overall the time complexity is O(n*log(n))
    Space complexity: O(n)
        In the worst case, no intervals are overlapping, and
        the stack will store will all the intervals. Thus, the space complexity is O(n).
 */
public class Solution_My_Way {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] {{}};
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        Deque<int[]> result = new LinkedList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
                continue;
            }

            int[] lastInterval = result.peekLast();

            if (lastInterval[1] < interval[0]) {
                result.add(interval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
