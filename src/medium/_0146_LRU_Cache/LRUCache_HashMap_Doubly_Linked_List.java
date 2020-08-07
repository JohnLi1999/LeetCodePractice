package medium._0146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_HashMap_Doubly_Linked_List {
    /*  https://leetcode.com/problems/lru-cache/
        Time complexity: O(1)
            Both for put and get.
        Space complexity: O(capacity)
            Since the space is used only for a HashMap and Double Linked List with at most capacity + 1 elements.
     */

    private final int capacity;
    private final Map<Integer, DoublyLinkListNode> map;
    private final DoublyLinkList list;

    public LRUCache_HashMap_Doubly_Linked_List(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoublyLinkList();
    }

    /*  Time Complexity: O(1)  */
    public int get(int key) {
        if (!map.containsKey(key)) {  // Time Complexity: O(1)
            return -1;
        }

        DoublyLinkListNode node = map.get(key);  // Time Complexity: O(1)
        list.remove(node);  // Time Complexity: O(1)
        list.insertHead(node);  // Time Complexity: O(1)

        return node.value;
    }

    /*  Time Complexity: O(1)  */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));  // Time Complexity: O(1)
        } else if(map.size() == capacity) {
            int removedKey = list.removeTail();  // Time Complexity: O(1)
            map.remove(removedKey);  // Time Complexity: O(1)
        }

        DoublyLinkListNode node = new DoublyLinkListNode(key, value);
        map.put(key, node);  // Time Complexity: O(1)
        list.insertHead(node);  // Time Complexity: O(1)
    }

    static class DoublyLinkList {
        /** Every Operation (insertHead, removeTail, remove)
         *  in this Doubly Linked List has O(1) Time Complexity  */

        DoublyLinkListNode head = new DoublyLinkListNode();
        DoublyLinkListNode tail = new DoublyLinkListNode();

        public DoublyLinkList() {
            /*  In this doubly linked list, head and tail are helper nodes which do not contain key and value
                (pseudo head and pseudo tail). So that we do not need to check the null node during the update.
                Here is the structure:
                head <=> [key1, value1] <=> [key2, value2] <=> ... <=> [keyN, valueN] <=> tail
             */
            head.next = tail;
            tail.prev = head;
        }

        /*  Time Complexity: O(1)  */
        public void insertHead(DoublyLinkListNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        /*  Time Complexity: O(1)  */
        public int removeTail() {
            DoublyLinkListNode nodeToRemove = tail.prev;
            remove(nodeToRemove);  // Time Complexity: O(1)
            return nodeToRemove.key;
        }

        /*  Time Complexity: O(1)  */
        private void remove(DoublyLinkListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    static class DoublyLinkListNode {
        int key;
        int value;
        DoublyLinkListNode prev;
        DoublyLinkListNode next;

        public DoublyLinkListNode() {}

        public DoublyLinkListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
