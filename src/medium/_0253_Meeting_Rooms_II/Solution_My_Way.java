package medium._0253_Meeting_Rooms_II;

import java.util.*;

/*  https://leetcode.com/problems/meeting-rooms-ii/
    Time complexity: O(n^2)
        For every new meeting, we traverse all previous meetings.
        So, in the worse case, we have O(n^2) time complexity
    Space complexity: O(n)
        We have a set of arraylists and save all meeting intervals.
        So the space complexity is O(n)
 */
public class Solution_My_Way {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        Set<List<int[]>> rooms = new HashSet<>();

        List<int[]> r0 = new ArrayList<>();
        r0.add(intervals[0]);
        rooms.add(r0);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            boolean newRoom = true;
            boolean foundRoom = false;

            for (List<int[]> room : rooms) {
                if (room.size() == 1) {
                    if (interval[1] <= room.get(0)[0]) {
                        room.add(0, interval);
                        newRoom = false;
                        break;
                    } else if (interval[0] >= room.get(0)[1]) {
                        room.add(interval);
                        newRoom = false;
                        break;
                    }
                }

                for (int j = 0; j < room.size(); j++) {
                    if (j == 0) {
                        if (interval[1] <= room.get(0)[0]) {
                            room.add(0, interval);
                            foundRoom = true;
                            break;
                        }
                    } else if (j == room.size() - 1 && interval[0] >= room.get(room.size() - 1)[1]) {
                        room.add(interval);
                        foundRoom = true;
                        break;
                    } else {
                        if (interval[0] >= room.get(j - 1)[1] && interval[1] <= room.get(j)[0]) {
                            room.add(j, interval);
                            foundRoom = true;
                            break;
                        }
                    }
                }

                if (foundRoom) {
                    newRoom = false;
                    break;
                }
            }

            if (newRoom) {
                List<int[]> room = new ArrayList<>();
                room.add(interval);
                rooms.add(room);
            }
        }

        return rooms.size();
    }
}
