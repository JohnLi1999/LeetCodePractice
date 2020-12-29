package medium._0253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*  https://leetcode.com/problems/meeting-rooms-ii/
    Time complexity: O(n*log(n))
    Space complexity: O(n)
 */
public class Solution_Priority_Queue {
    public int minMeetingRooms(int[][] intervals) {
        // Boundary check
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }

        // Sort all interval by staring time
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));

        // Create a priority queue to save all ending time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the ending time of the first interval
        minHeap.add(intervals[0][1]);

        // Traverse all the intervals
        for (int i = 1; i < intervals.length; i++) {
            /*  If there is a room available for the new interval,
                we pull out the the top element of the min heap and update it  */
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Add the ending time of the new interval
            minHeap.add(intervals[i][1]);
        }

//        // Another Implementation
//        for (int[] interval : intervals) {
//            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()) {
//                minHeap.poll();
//            }
//
//            minHeap.add(interval[1]);
//        }

        // The minimum number of the rooms needed is the same as the heap's size
        return minHeap.size();
    }
}
