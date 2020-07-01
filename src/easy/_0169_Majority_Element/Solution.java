package easy._0169_Majority_Element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*  https://leetcode.com/problems/majority-element/
        Time complexity: O(n)
            We iterate over nums once and make a constant time HashMap insertion on each iteration.
            Therefore, the algorithm runs in O(n) time.
        Space complexity: O(n)
            At most, the HashMap can contain (n - ⌊ n/2 ⌋) associations, so it occupies O(n) space.
            This is because an arbitrary array of length n can contain n distinct values,
            but nums is guaranteed to contain a majority element, which will
            occupy (at minimum) (⌊ n/2 ⌋ + 1) array indices. Therefore, (⌊ n/2 ⌋ + 1) indices
            can be occupied by distinct, non-majority elements (plus 1 for the majority element itself),
            leaving us with (at most) (n - ⌊ n/2 ⌋) distinct elements.
     */
    public static int majorityElement_HashMap(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;

        for (int num : nums) {
            if (map.containsKey(num)) {
                int count = map.get(num) + 1;
                if (count > half) {
                    return num;
                }
                map.replace(num, count);
            } else {
                map.put(num, 1);
            }
        }

        return 0;
    }

    /*  Time complexity: O(n)
            Boyer-Moore performs constant work exactly n times, so the algorithm runs in linear time.
        Space complexity: O(1)
            Boyer-Moore allocates only constant additional memory.
     */
    public static int majorityElement_MooreVoting(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorityElement = nums[i];
            }

            count += (nums[i] == majorityElement) ? 1 : -1;
        }

        return majorityElement;
    }
}
