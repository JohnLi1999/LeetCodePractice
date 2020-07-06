package medium._0022_Generate_Parentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static medium._0022_Generate_Parentheses.Solution.generateParenthesis;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        int input = 1;
        List<String> expectedResult = List.of("()");
        assertEquals(expectedResult, generateParenthesis(input));
    }

    @Test
    void test2() {
        int input = 2;
        List<String> expectedResult = List.of("(())", "()()");
        assertEquals(expectedResult, generateParenthesis(input));
    }

    @Test
    void test3() {
        int input = 3;
        List<String> expectedResult = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
        assertEquals(expectedResult, generateParenthesis(input));
    }
}