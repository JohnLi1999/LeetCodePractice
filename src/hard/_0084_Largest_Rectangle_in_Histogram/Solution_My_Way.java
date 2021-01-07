package hard._0084_Largest_Rectangle_in_Histogram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*  https://leetcode.com/problems/largest-rectangle-in-histogram/
    Time complexity: O(n^2), where n is the number of heights
        We used nested loops.
        In the worst case, the heights are sorted in ascending order.
        The inner loops will traverse all i elements searching so far.
        It will be 1 + 2 + ... + (n - 1) + n = n*(n + 1)/2, and time complexity is O(n^2)
    Space complexity: O(n)
        In the worst case, the heights given are sort in ascending order,
        so the hashmap may save all the heights
 */
public class Solution_My_Way {
    public int largestRectangleArea(int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();

        int first = heights[0];
        map.put(first, first);
        int max = first;

        for (int i = 1; i < heights.length; i++) {
            int current = heights[i];

            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int key = it.next();
                if (current < key) {
                    it.remove();
                } else {
                    map.put(key, map.get(key) + key);
                }
            }

            if (!map.containsKey(current) && current != 0) {
                map.put(current, current);

                for (int j = i - 1; j >= 0; j--) {
                    if (heights[j] < current) {
                        break;
                    }

                    map.put(current, map.get(current) + current);
                }
            }

            for (int key: map.keySet()) {
                int candidate = map.get(key);
                if (candidate > max) {
                    max = candidate;
                }
            }
        }

        return max;
    }
}
