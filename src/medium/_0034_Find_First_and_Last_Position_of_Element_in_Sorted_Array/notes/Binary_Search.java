package medium._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array.notes;

/*  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    Time complexity: O(logN)
        Here we invoke binary search twice. Let's compute time complexity with the help of master theorem
        T(N) = aT(N/b) + Θ(N^d). The equation represents dividing the problem up into a
         subproblems of size (N/b) in Θ(N^d) time. Here at step there is only one subproblem a = 1,
         its size is a half of the initial problem b = 2, and all this happens in a constant time d = 0.
         That means that log_b(a) = d and hence we're dealing with case 2 that results in
         O(n^{log_b(a)} * log(d+1) * N) = O(logN) time complexity.
    Space complexity: O(1)
        All work is done in place, so the overall memory usage is constant.
 */
public class Binary_Search {
    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
}
