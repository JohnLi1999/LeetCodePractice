package easy._0020_Valid_Parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0020_Valid_Parentheses.Solution.isValid;

class Tests {

    @Test
    void test1() {
        String input = "()";
        assertTrue(isValid(input));
    }

    @Test
    void test2() {
        String input = "()[]{}";
        assertTrue(isValid(input));
    }

    @Test
    void test3() {
        String input = "(]";
        assertFalse(isValid(input));
    }

    @Test
    void test4() {
        String input = "([)]";
        assertFalse(isValid(input));
    }

    @Test
    void test5() {
        String input = "([])";
        assertTrue(isValid(input));
    }

    @Test
    void test6() {
        String input = "";
        assertTrue(isValid(input));
    }
}