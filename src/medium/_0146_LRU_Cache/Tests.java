package medium._0146_LRU_Cache;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Nested
    class HashMap_Doubly_Linked_List {
        @Test
        void test1() {
            LRUCache_HashMap_Doubly_Linked_List cache = new LRUCache_HashMap_Doubly_Linked_List(2);

            cache.put(1, 1);
            cache.put(2, 2);
            assertEquals(1, cache.get(1));
            cache.put(3, 3);
            assertEquals(-1, cache.get(2));
            cache.put(4, 4);
            assertEquals(-1, cache.get(1));
            assertEquals(3, cache.get(3));
            assertEquals(4, cache.get(4));
        }

        @Test
        void test2() {
            LRUCache_HashMap_Doubly_Linked_List cache = new LRUCache_HashMap_Doubly_Linked_List(1);

            cache.put(2, 1);
            assertEquals(1, cache.get(2));
            cache.put(3, 2);
            assertEquals(-1, cache.get(2));
            assertEquals(2, cache.get(3));
        }
    }

    @Nested
    class HashMap_Queue {
        @Test
        void test1() {
            LRUCache_HashMap_Queue cache = new LRUCache_HashMap_Queue(2);

            cache.put(1, 1);
            cache.put(2, 2);
            assertEquals(1, cache.get(1));
            cache.put(3, 3);
            assertEquals(-1, cache.get(2));
            cache.put(4, 4);
            assertEquals(-1, cache.get(1));
            assertEquals(3, cache.get(3));
            assertEquals(4, cache.get(4));
        }
    }
}