package medium._0056_Merge_Intervals.notes;

import java.util.Arrays;
import java.util.LinkedList;

/*  https://leetcode.com/problems/merge-intervals/
    Time complexity: O(n*log(n))
        Other than the sort invocation, we do a simple linear scan of the list,
        so the runtime is dominated by the O(n*log(n)) complexity of sorting.
    Space complexity: O(log(n)) (or O(n))
        If we can sort intervals in place, we do not need more than constant additional space,
        although the sorting itself takes O(log(n)) space.
        Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 */
public class Sorting {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}