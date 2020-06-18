package easy._0242_Valid_Anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0242_Valid_Anagram.Solution.isAnagram;

class Tests {

    @Test
    void test1() {
        String input1 = "anagram";
        String input2 = "nagaram";
        assertTrue(isAnagram(input1, input2));
    }

    @Test
    void test2() {
        String input1 = "rat";
        String input2 = "car";
        assertFalse(isAnagram(input1, input2));
    }
}