package medium._0347_Top_K_Frequent_Elements.notes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*  Time complexity: O(N) in the average case
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
public class QuickSelect {
    int[] unique;
    Map<Integer, Integer> count;

    public void swap(int a, int b) {
        int tmp = unique[a];
        unique[a] = unique[b];
        unique[b] = tmp;
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot_frequency = count.get(unique[pivot_index]);
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all less frequent elements to the left
        for (int i = left; i <= right; i++) {
            if (count.get(unique[i]) < pivot_frequency) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    public void quickselect(int left, int right, int k_smallest) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

        // base case: the list contains only one element
        if (left == right) return;

        // select a random pivot_index
        Random random_num = new Random();
        int pivot_index = left + random_num.nextInt(right - left);

        // find the pivot position in a sorted list
        pivot_index = partition(left, right, pivot_index);

        // if the pivot is in its final sorted position
        if (k_smallest == pivot_index) {
            return;
        } else if (k_smallest < pivot_index) {
            // go left
            quickselect(left, pivot_index - 1, k_smallest);
        } else {
            // go right
            quickselect(pivot_index + 1, right, k_smallest);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        count = new HashMap();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num: count.keySet()) {
            unique[i] = num;
            i++;
        }

        // kth top frequent element is (n - k)th less frequent.
        // Do a partial sort: from less frequent to the most frequent, till
        // (n - k)th less frequent element takes its place (n - k) in a sorted array.
        // All element on the left are less frequent.
        // All the elements on the right are more frequent.
        quickselect(0, n - 1, n - k);
        // Return top k frequent elements
        return Arrays.copyOfRange(unique, n - k, n);
    }
}