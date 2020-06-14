package easy._0009_Palindrome_Number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0009_Palindrome_Number.Solution.isPalindrome;

class Tests {

    @Test
    void test1() {
        int input = 121;
        assertTrue(isPalindrome(input));
    }

    @Test
    void test2() {
        int input = -121;
        assertFalse(isPalindrome(input));
    }

    @Test
    void test3() {
        int input = 10;
        assertFalse(isPalindrome(input));
    }

    @Test
    void test4() {
        int input = 123454321;
        assertTrue(isPalindrome(input));
    }

    @Test
    void test5() {
        int input = 1234543210;
        assertFalse(isPalindrome(input));
    }

    @Test
    void test6() {
        int input = 1234554321;
        assertTrue(isPalindrome(input));
    }
}