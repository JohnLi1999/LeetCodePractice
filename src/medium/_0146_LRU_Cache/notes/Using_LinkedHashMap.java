package medium._0146_LRU_Cache.notes;

import java.util.LinkedHashMap;
import java.util.Map;

/*  Time complexity: O(1)
        Both for put and get since
        all operations with ordered dictionary (get/containsKey/put/remove) are done in a constant time.
    Space complexity: O(capacity)
        Since the space is used only for an ordered dictionary with at most capacity + 1 elements.
 */
public class Using_LinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public Using_LinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}