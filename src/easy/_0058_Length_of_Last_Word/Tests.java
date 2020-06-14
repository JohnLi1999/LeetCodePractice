package easy._0058_Length_of_Last_Word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0058_Length_of_Last_Word.Solution.lengthOfLastWord;

class Tests {

    @Test
    void test1() {
        String input = "Hello World";
        int expectResult = 5;
        assertEquals(expectResult, lengthOfLastWord(input));
    }

    @Test
    void test2() {
        String input = "Hello ";
        int expectResult = 5;
        assertEquals(expectResult, lengthOfLastWord(input));
    }

    @Test
    void test3() {
        String input = " Hello ";
        int expectResult = 5;
        assertEquals(expectResult, lengthOfLastWord(input));
    }


    @Test
    void test4() {
        String input = " Hel lo ";
        int expectResult = 2;
        assertEquals(expectResult, lengthOfLastWord(input));
    }

    @Test
    void test5() {
        String input = "";
        int expectResult = 0;
        assertEquals(expectResult, lengthOfLastWord(input));
    }

    @Test
    void test6() {
        String input = "             ";
        int expectResult = 0;
        assertEquals(expectResult, lengthOfLastWord(input));
    }

    @Test
    void test7() {
        String input = "A             ";
        int expectResult = 1;
        assertEquals(expectResult, lengthOfLastWord(input));
    }
}