package medium._0033_Search_in_Rotated_Sorted_Array.round_2;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums;
        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 0)); // 4
        nums = new int[] {4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 3)); // -1
        nums = new int[] {1};
        System.out.println(s.search(nums, 0)); // -1
        nums = new int[] {4,5,6,7,8,1,2,3};
        System.out.println(s.search(nums, 8)); // 4
        nums = new int[] {3,5,1};
        System.out.println(s.search(nums, 3)); // 0
        nums = new int[] {5,1,3};
        System.out.println(s.search(nums, 3)); // 2
        nums = new int[] {3,1};
        System.out.println(s.search(nums, 1)); // 1
    }

    /*  Be careful with the edge case and the logic
        Time complexity: O(log(n))
        Space complexity: O(1)
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;

        while (low <= high) {
            middle = low + ((high - low) / 2);

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                /*  Normally, in this case we should search for left half, but

                    nums[low] <= nums[middle]
                        -> left half is sorted
                    target < nums[low]
                        -> So, target is rotated to the right half
                 */
                if (nums[low] <= nums[middle] && target < nums[low]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            } else {
                /*  Normally, in this case we should search for right half, but

                    nums[middle] <= nums[high]
                        -> right half is sorted
                    target > nums[high]
                        -> So, target is rotated to the left half
                 */
                if (nums[middle] <= nums[high] && target > nums[high]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }

        return -1;
    }
}
