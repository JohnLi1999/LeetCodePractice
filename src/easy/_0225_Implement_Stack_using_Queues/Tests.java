package easy._0225_Implement_Stack_using_Queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertFalse(stack.empty());
        assertEquals(1, stack.top());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }
}