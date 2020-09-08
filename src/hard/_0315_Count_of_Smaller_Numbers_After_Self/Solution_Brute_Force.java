package hard._0315_Count_of_Smaller_Numbers_After_Self;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*  https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    Time Complexity: O(n^2)
        Nested loops
    Space Complexity: O(n)
        Need to store the count for each element in the given array
 */
public class Solution_Brute_Force {
    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                result[i] = 0;
                continue;
            }

            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
