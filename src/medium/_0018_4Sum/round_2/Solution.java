package medium._0018_4Sum.round_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

//        List<List<Integer>> results = s.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
        List<List<Integer>> results = s.fourSum(new int[] {2,2,2,2,2}, 8);

        results.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> solution = new ArrayList<>();

    /*  Use two pointers
        Time complexity: O(n^3)
        Space complexity: O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            solution.add(nums[i]);
            threeSum(nums, i + 1, target - nums[i]);
            solution.remove(0);
        }

        return results;
    }

    public void threeSum(int[] nums, int startIndex, int target) {
        for (int i = startIndex; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            solution.add(nums[i]);
            twoSum(nums, i + 1, target - nums[i]);
            solution.remove(solution.size() - 1);
        }
    }

    public void twoSum(int[] nums, int startIndex, int target) {
        int i = startIndex;
        int j = nums.length - 1;

        while (i < j) {
            // Skip duplicates
            if (nums[i] + nums[j] > target || (j < nums.length - 1 && nums[j] == nums[j + 1])) {
                j--;
            } else if (nums[i] + nums[j] < target || (i > startIndex && nums[i] == nums[i - 1])) {
                i++;
            } else {
                solution.add(nums[i]);
                solution.add(nums[j]);

                results.add(new LinkedList<>(solution));

                solution.remove(3);
                solution.remove(2);

                i++;
                j--;
            }
        }
    }
}
