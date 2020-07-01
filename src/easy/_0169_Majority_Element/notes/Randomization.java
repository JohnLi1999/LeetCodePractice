package easy._0169_Majority_Element.notes;

import java.util.Random;

public class Randomization {
    /*  Time complexity: O(∞)
            Check 0169. Majority Element.png for more details
        Space complexity: O(1)
            Much like the brute force solution, the randomized approach runs with constant additional space.
     */
    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length/2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurrences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurrences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}