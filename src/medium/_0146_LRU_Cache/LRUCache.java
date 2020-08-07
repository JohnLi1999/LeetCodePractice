package medium._0146_LRU_Cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    private final HashMap<Integer, Integer> map;
    private final Deque<Integer> keys;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        keys = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            keys.remove(key);
            keys.add(key);

            return map.get(key);
        }

        return -1;
    }

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