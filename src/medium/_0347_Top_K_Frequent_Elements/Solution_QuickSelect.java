package medium._0347_Top_K_Frequent_Elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*  https://leetcode.com/problems/top-k-frequent-elements/
    Time complexity: O(N) in the average case
                     O(N^2) in the worst case
            Please refer to this card for the good detailed explanation of Master Theorem
        (https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2871/).
        Master Theorem helps to get an average complexity by writing the algorithm cost as
        T(N) = a * T(N/b) + f(N). Here we have an example of Master Theorem case III:
        T(N) = T(N/2) + N, that results in O(N) time complexity. That's the case of random pivots.
            In the worst-case of constantly bad chosen pivots, the problem is not divided by half at each step,
        it becomes just one element less, that leads to O(N^2) time complexity. It happens, for example,
        if at each step you choose the pivot not randomly, but take the rightmost element.
        For the random pivot choice the probability of having such a worst-case is negligibly small.
    Space complexity: O(N)
        Up to O(N) to store hash map and array of unique elements.
 */
public class Solution_QuickSelect {
    int[] values;
    Map<Integer, Integer> map;

    public int[] topKFrequent(int[] nums, int k) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int N = map.size();
        values = new int[N];
        int i = 0;
        for (Integer num : map.keySet()) {
            values[i++] = num;
        }

        // The targetIndex is (N - k)
        quickSelect(0, N - 1, N - k);
        return Arrays.copyOfRange(values, N - k, N);
    }

    public void quickSelect(int left, int right, int targetIndex) {
        // Terminate when left and right indices meet
        if (left == right) {
            return;
        }

        Random r = new Random();
        /*  Generate a random number between left and right (inclusive both ends) indices
            as the starting pivot_index  */
        int pivotIndex = left + r.nextInt(right - left + 1);

        pivotIndex = partition(left, right, pivotIndex);

        // Terminate when the pivot index is our target index
        if (pivotIndex == targetIndex) {
            return;
        } else if (pivotIndex > targetIndex) {
            // Keep the LEFT side of the pivot index if it is larger than the target index
            quickSelect(left, pivotIndex - 1, targetIndex);
        } else {
            // Keep the RIGHT side of the pivot index if it is smaller than the target index
            quickSelect(pivotIndex + 1, right, targetIndex);
        }
    }

    public int partition (int left, int right, int pivotIndex) {
        // Save the count of the pivot
        int pivot = map.get(values[pivotIndex]);
        // Swap pivot to the rightmost of the values array
        swap(pivotIndex, right);
        // Initialize the counter to the left index
        int i = left;

        // We do not need to  check the last element since we have swap the pivot there
        for (int j = left; j < right; j++) {
            if (map.get(values[j]) < pivot) {
                swap(i, j);
                i++;
            }
        }

        /*  After searching all the elements between left and right, i is the next pivot index
            We swap the previous pivot to i, and return i  */
        swap(i, right);
        return i;
    }

    public void swap(int index1, int index2) {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
}
