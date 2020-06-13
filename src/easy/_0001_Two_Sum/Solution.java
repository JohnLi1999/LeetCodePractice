package easy._0001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
        https://leetcode.com/problems/two-sum/
        Time Complexity: O(n)
        Space Complexity: O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        throw null;
    }
}
