package medium._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

/*  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    Time complexity: O(logN)
    Space complexity: O(1)
 */
public class Solution_Bounds {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = searchLowerBound(nums, target);
        int upperBound = searchUpperBound(nums, target);

        return new int[] {lowerBound, upperBound};
    }

    /* Search the lower bound for the target value */
    public int searchLowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            /*  For the lower bound, it needs to satisfy
                    1. nums[middle] == target
                    2. middle == 0 or nums[middle - 1] < target
             */
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
                return middle;
            }

            /*  Be careful of '<=' used here,
                since we always want to search the left half
                if nums[middle] == target for the lower bound  */
            if (target <= nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    /* Search the lower bound for the target value */
    public int searchUpperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            /*  For the upper bound, it needs to satisfy
                    1. nums[middle] == target
                    2. middle == nums.length - 1 or nums[middle + 1] > target
             */
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > target)) {
                return middle;
            }

            /*  Be careful of '<' used here,
                since we always want to search the right half
                if nums[middle] == target for the upper bound  */
            if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
