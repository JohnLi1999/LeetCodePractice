package medium._0435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

/*  https://leetcode.com/problems/non-overlapping-intervals/
    Time complexity: O(n*log(n))
        1. Sort the intervals take O(n*log(n)) time
        2. Traverse the intervals to check overlapping takes O(n) time
        So, overall the time complexity is O(n*log(n))
    Space complexity: O(1)
        We only use prev, curr, and next pointers. So it is constant space complexity
 */
public class Solution_My_Way_Greedy {
    /** Greedy Algorithm is used **/
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return 0;
        }

        /* Sort all intervals in ascending order by the start position */
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        /*  Overall strategy: we need to track three intervals: previous, current, and next

            Condition I: prev and curr do not overlap
                => update prev to curr

            Condition II: prev and curr overlap
                Now we also need to the next interval

                Case 1: prev and curr overlap, but prev and next do not overlap
                    =>  curr is the unnecessary interval.
                        Skip curr and increase counter
                Case 2: prev and curr overlap, prev and next overlap, but curr and next do not overlap
                    =>  prev is the unnecessary interval.
                        Update prev to curr and increase counter
                Case 3: prev, curr, and next all overlap
                    =>  In this case, any of the two need to be removed. However, actually we want the ending
                        position of the previous intervals to be as small as possible. So, we will do
                        the following check

                        Check 1: If the end position of prev is larger than that of curr (prev[1] > curr[1])
                            =>  Update curr to prev and increase counter
                        Check 2: Otherwise (prev[1] <= curr[1])
                            =>  Skip curr and increase counter
         */

        int count = 0;
        int[] prev = intervals[0];
        int[] curr, next;

        for (int i = 1; i < intervals.length; i++) {
            curr = intervals[i];

            if (prev[1] <= curr[0]) {
                prev = curr;
            } else {
                if (i == intervals.length - 1) {
                    count++;
                    break;
                }

                next = intervals[i + 1];

                if (prev[1] > next[0]) {
                    if (curr[1] <= next[0]) {
                        prev = curr;
                    } else {
                        prev = prev[1] <= curr[1] ? prev : curr;
                    }
                }

                count++;
            }
        }

        return count;
    }
}
