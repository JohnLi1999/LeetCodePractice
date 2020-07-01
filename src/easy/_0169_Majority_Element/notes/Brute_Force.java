package easy._0169_Majority_Element.notes;

public class Brute_Force {
    /*  Time complexity: O(n^2)
            The brute force algorithm contains two nested for loops that each run for nn iterations,
            adding up to quadratic time complexity.
        Space complexity : O(1)
            The brute force solution does not allocate additional space proportional to the input size.
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }

        }

        return -1;
    }
}
