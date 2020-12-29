package medium._0253_Meeting_Rooms_II;

import java.util.Arrays;

/*  https://leetcode.com/problems/meeting-rooms-ii/
    Time complexity: O(n*log(n))
    Space complexity: O(n)
 */
public class Solution_Start_End {
    public int minMeetingRooms(int[][] intervals) {
        // Record the start and end time of all intervals
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(starts);
        Arrays.sort(ends);

        // Traverse all start time and set the end index to zero
        int rooms = 0;
        int end_index = 0;
        for (int i = 0; i < starts.length; i++) {
            /*  If the start time is smaller than the end time of the room,
                it means all rooms are busy, so we need an extra room  */
            if (starts[i] < ends[end_index]) {
                rooms++;
            } else {
                /*  Otherwise, it means we can reuse the room,
                    and we also need to update the end index  */
                end_index++;
            }
        }

        return rooms;
    }
}
