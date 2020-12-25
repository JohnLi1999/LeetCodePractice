package medium._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array.notes;

/*  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    Time complexity: O(n)
        This brute-force approach examines each of the n elements of nums exactly twice,
        so the overall runtime is linear.
    Space complexity: O(1)
        The linear scan method allocates a fixed-size array and a few integers,
        so it has a constant-size memory footprint.
 */
public class Linear_Scan {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        // find the index of the leftmost appearance of `target`.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }

        // if the last loop did not find any index, then there is no valid range
        // and we return [-1, -1].
        if (targetRange[0] == -1) {
            return targetRange;
        }

        // find the index of the rightmost appearance of `target` (by reverse
        // iteration). it is guaranteed to appear.
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }

        return targetRange;
    }
}