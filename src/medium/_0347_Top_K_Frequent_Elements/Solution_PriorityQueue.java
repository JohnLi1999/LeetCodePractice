package medium._0347_Top_K_Frequent_Elements;

import java.util.*;

/*  https://leetcode.com/problems/top-k-frequent-elements/
    Time complexity: O(N*log(k))
    Space complexity: O(N)
        To store the hash map and a linked list with not more N elements, and a heap with N elements.
 */
public class Solution_PriorityQueue {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Pair> list = new LinkedList<>();

        for (Integer key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator()); // max heap

        for (Pair pair : list) {
            pq.add(pair);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().num;
        }

        return result;
    }
}

class Pair {
    public int num;
    public int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair pair1, Pair pair2) {
        if (pair1.count < pair2.count) {
            return 1;
        } else if (pair1.count > pair2.count) {
            return -1;
        } else {
            return 0;
        }
    }
}

