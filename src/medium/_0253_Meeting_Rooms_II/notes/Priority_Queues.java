package medium._0253_Meeting_Rooms_II.notes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*  https://leetcode.com/problems/meeting-rooms-ii/
    Time Complexity: O(N*log(N)).
        There are two major portions that take up time here.
        One is sorting of the array that takes O(N*log(N)) considering that the array consists of N elements.
        Then we have the min-heap. In the worst case, all N meetings will collide with each other.
        In any case we have N add operations on the heap.
        In the worst case we will have N extract-min operations as well.
        Overall complexity being (N*log(N)) since extract-min operation on a heap takes O(log(N)).
    Space Complexity: O(N)
        Because we construct the min-heap and that can contain N elements in the worst case
        as described above in the time complexity section. Hence, the space complexity is O(N).
 */
public class Priority_Queues {
    public int minMeetingRooms(int[][] intervals) {

        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}