package medium._0146_LRU_Cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache_HashMap_Queue {
    /*  https://leetcode.com/problems/lru-cache/
        Time complexity: O(capacity)
            Both for get and put operations
            In both operations, we need to search for the position of key and update it in the queue.
            This might takes O(capacity) time complexity
        Space complexity: O(capacity)
            Since the space is used for a hashmap and a queue with capacity elements
     */

    private final HashMap<Integer, Integer> map;
    private final Deque<Integer> keys;
    private final int capacity;

    public LRUCache_HashMap_Queue(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        keys = new LinkedList<>();
    }

    /* Time Complexity: O(capacity) */
    public int get(int key) {
        if (map.containsKey(key)) {
            keys.remove(key);
            keys.add(key);

            return map.get(key);
        }

        return -1;
    }

    /* Time Complexity: O(capacity) */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            keys.remove(key);
        } else if (keys.size() == capacity) {
            int removedKey = keys.remove();
            map.remove(removedKey);
        }

        keys.add(key);
        map.put(key, value);
    }
}