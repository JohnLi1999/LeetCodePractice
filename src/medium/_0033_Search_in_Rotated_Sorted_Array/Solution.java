package medium._0033_Search_in_Rotated_Sorted_Array;

/*  https://leetcode.com/problems/search-in-rotated-sorted-array/
    Time complexity: O(log(n))
        We used binary search
    Space complexity: O(1)
 */
public class Solution {
    public int search(int[] nums, int target) {
        return better_way(nums, target);
//        return my_way(nums, target);
    }

    private int better_way(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            /* Case 1: left half is sorted properly (nums[low] <= nums[middle]) */
            if (nums[low] <= nums[middle]) {
                if (nums[low] <= target && target < nums[middle]) {
                    /*  Since left half is properly sorted, we can safely check if the target
                        is within the left half of the array.
                        And be careful of the case that nums[low] == target
                     */
                    high = middle - 1;
                } else {
                    // Otherwise, the target is in the right half
                    low = middle + 1;
                }
            }
            /* Case 2: if not, then right half is sorted properly */
            else {
                if (nums[middle] < target && target <= nums[high]) {
                    /*  Since right half is properly sorted, we can safely check if the target
                        is within the right half of the array.
                        And be careful of the case that target == nums[high]
                     */
                    low = middle + 1;
                } else {
                    // Otherwise, the target is in the left half
                    high = middle - 1;
                }
            }
        }

        return -1;
    }

    private int my_way(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // Case nums[middle] is larger than target
            if (nums[middle] > target) {
                if (target < nums[low] && nums[low] <= nums[middle]) {
                    /*  Special case:
                        Numbers from index low to middle is sorted (nums[low] <= nums[middle]),
                        but the target is still smaller than nums[low] (target < nums[low])
                        This indicates the target is on right half, which is the rotated section
                     */
                    low = middle + 1;
                } else {
                    // Normal case, search the left half of the array
                    high = middle - 1;
                }
            } else {  // Case nums[middle] is smaller than target
                if (target > nums[high] && nums[high] >= nums[middle]) {
                    /*  Special case:
                        Numbers from index middle to high is sorted (nums[high] >= nums[middle]),
                        but the target is still larger than nums[high] (target > nums[high])
                        This indicates the target is on left half, which is the rotated section
                     */
                    high = middle - 1;
                } else {
                    // Normal case, search the right half of the array
                    low = middle + 1;
                }
            }
        }

        return -1;
    }
}
