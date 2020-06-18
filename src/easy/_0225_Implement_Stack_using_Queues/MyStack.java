package easy._0225_Implement_Stack_using_Queues;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    /* https://leetcode.com/problems/implement-stack-using-queues/ */

    // Declare a queue
    private Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        // Initialize a queue with LinkedList
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    /*  Time complexity: O(n)
            The algorithm removes n elements and inserts n + 1 elements to the queue,
            where n is the stack size. This gives 2n + 1 operations.
            The operations add and remove in linked lists has O(1) complexity.
        Space complexity: O(1)
     */
    public void push(int x) {
        // Insert the new value at the end of the queue
        queue.offer(x);
        int size = queue.size();
        /*  Move the previous (size - 1) values to the back,
            so the latest value will come to the beginning of the queue. */
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
