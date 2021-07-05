package easy._0169_Majority_Element.round_2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[] {3,2,3}));
        System.out.println(s.majorityElement(new int[] {2,2,1,1,1,2,2}));
    }

    /*  Using HashMap to track the count of all the numbers
        Time complexity: O(n)
        Space complexity: O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int half = nums.length / 2;

        for (int key : map.keySet()) {
            if (map.get(key) > half) {
                return key;
            }
        }

        return -1;
    }
}
