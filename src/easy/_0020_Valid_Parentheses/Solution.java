package easy._0020_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Solution {
    /*  https://leetcode.com/problems/valid-parentheses/
        Time complexity : O(n)
            Because we simply traverse the given string one character at a time, and
            push and pop operations on a stack take O(1) time.
        Space complexity : O(n)
            As we push all opening brackets onto the stack, and
            in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
     */
    public static boolean isValid(String s) {
        // Utility Map
        Map<Character, Character> map = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                /*  Case for meeting a closing bracket
                    If the stack does not have any value inside, return false
                    If the top element does not match the given char, return false
                 */
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                // Case for not meet a closing bracket yet, then add the char into the stack
                stack.push(c);
            }
        }

        // The stack should be empty after iterating a valid string
        return stack.isEmpty();
    }
}
