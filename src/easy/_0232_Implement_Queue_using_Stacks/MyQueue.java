package easy._0232_Implement_Queue_using_Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    /*  https://leetcode.com/problems/implement-queue-using-stacks/ */

    /* A Better Solution_PureBacktracking */
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private Integer front;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
        front = null;
    }

    /** Push element x to the back of queue. */
    /*  Time complexity: O(1)
            Appending an element to a stack is an O(1) operation.
        Space complexity: O(n)
            We need additional memory to store the queue elements
     */
    public void push(int x) {
        if (s1.isEmpty()) {
            // If stack 1 is not empty, set the front of the queue to the first element added into stack 1
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    /*  Time complexity: Amortized O(1), Worst-case O(n)
            In the worst case scenario when stack s2 is empty,
            the algorithm pops n elements from stack s1 and pushes n elements to s2,
            where n is the queue size. This gives 2n operations, which is O(n).
            But when stack s2 is not empty the algorithm has O(1) time complexity.
                So what does it mean by Amortized O(1)?
                Please check "0232. Implement Queue using Stacks.png"
        Space complexity: O(1)
     */
    public int pop() {
        // When stack 2 is empty, add all elements in stack 1 into stack 2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Always pop value from stack 2
        return s2.pop();
    }

    /** Get the front element. */
    /*  Time complexity: O(1)
            The front element was either previously calculated or returned as a top element of stack s2.
            Therefore complexity is O(1)
        Space complexity: O(1)
     */
    public int peek() {
        // If stack 2 is not empty, return the value peeked from stack 2
        if (!s2.isEmpty()) {
            return s2.peek();
        }

        // Otherwise return front
        return front;
    }

    /** Returns whether the queue is empty. */
    /*  Time complexity: O(1)
        Space complexity: O(1)
     */
    public boolean empty() {
        // The queue is empty when both stacks are empty
        return s1.isEmpty() && s2.isEmpty();
    }


    /* My Initial Way*/
//    private Deque<Integer> stack;
//    private Deque<Integer> helper;
//
//    /** Initialize your data structure here. */
//    public MyQueue() {
//        stack = new ArrayDeque<>();
//        helper = new ArrayDeque<>();
//    }
//
//    /** Push element x to the back of queue. */
//    /*  Time complexity: O(n)
//            Each element, with the exception of the newly arrived, is pushed and popped twice.
//            The last inserted element is popped and pushed once.
//            Therefore this gives 4 n + 2 operations where nn is the queue size.
//            The push and pop operations have O(1) time complexity.
//        Space complexity: O(n)
//            We need additional memory to store the queue elements
//     */
//    public void push(int x) {
//        while(!stack.isEmpty()) {
//            helper.push(stack.pop());
//        }
//
//        stack.push(x);
//
//        while (!helper.isEmpty()) {
//            stack.push(helper.pop());
//        }
//    }
//
//    /** Removes the element from in front of queue and returns that element. */
//    /*  Time complexity: O(1)
//        Space complexity: O(1)
//     */
//    public int pop() {
//        return stack.pop();
//    }
//
//    /** Get the front element. */
//    /*  Time complexity: O(1)
//        Space complexity: O(1)
//     */
//    public int peek() {
//        return stack.peek();
//    }
//
//    /*  Time complexity: O(1)
//        Space complexity: O(1)
//     */
//    /** Returns whether the queue is empty. */
//    public boolean empty() {
//        return stack.isEmpty();
//    }
}
