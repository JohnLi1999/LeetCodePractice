package medium._0253_Meeting_Rooms_II.round_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals;
        intervals = new int[][] {{0,30},{5,10},{15,20}};
        System.out.println(s.minMeetingRooms(intervals)); // 2
        intervals = new int[][] {{7,10},{2,4}};
        System.out.println(s.minMeetingRooms(intervals)); // 1
        intervals = new int[][] {{13,15},{1,13}};
        System.out.println(s.minMeetingRooms(intervals)); // 1        
        intervals = new int[][] {{2,15},{36,45},{9,29},{16,23},{4,9}};
        System.out.println(s.minMeetingRooms(intervals)); // 2
    }

    /*  Time complexity: O(n*log(n))
        Space complexity: O(n)
     */
    public int minMeetingRooms(int[][] intervals) {
        // Sort the array with start time
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        /*  Save the end time in the min heap
            At the end, the size of the min heap is the number of rooms needed
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= minHeap.peek()) {
               minHeap.poll();
            }
            minHeap.add(interval[1]);
        }

        return minHeap.size();
    }
}
