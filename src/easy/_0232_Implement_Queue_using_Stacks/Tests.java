package easy._0232_Implement_Queue_using_Stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.peek());
        assertFalse(queue.empty());
        assertEquals(3, queue.pop());
        assertTrue(queue.empty());
    }
}