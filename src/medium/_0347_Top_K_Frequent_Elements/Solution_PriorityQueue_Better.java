package medium._0347_Top_K_Frequent_Elements;

import java.util.*;

/*  https://leetcode.com/problems/top-k-frequent-elements/
    Time complexity: O(N*log(k)) if k < N and
    Space complexity: O(N + k)
        To store the hash map with not more N elements and a heap with k elements.
 */
public class Solution_PriorityQueue_Better {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /*  Max Heap
            (num1, num2) -> (map.get(num1) - map.get(num2)) is Ascending Order
            (num1, num2) -> (map.get(num2) - map.get(num1)) is Descending Order
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> (map.get(num2) - map.get(num1)));

        for (Integer num : map.keySet()) {
            pq.add(num);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }

        return result;
    }
}