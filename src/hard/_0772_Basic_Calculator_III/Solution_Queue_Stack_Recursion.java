package hard._0772_Basic_Calculator_III;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*  https://leetcode.com/problems/basic-calculator-iii/
    Time complexity: O(n), where n is the number of characters in the input string
        In preparation stage, we traverse the string once, and it takes O(n) time
        Then we traverse the queue, it also takes O(n) time.
        So the overall time complexity is O(n)
    Space complexity: O(n)
        For the worst case, we save (n-1) characters into the queue.
        So the space complexity is O(n)
 */
public class Solution_Queue_Stack_Recursion {
    private final Deque<Character> queue = new LinkedList<>();

    public int calculate(String s) {
        /* Preparation */
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.add(c);
            }
        }
        queue.add('+');

        /*  For the expression inside parentheses, we can handle it by recursion
            First calculate the expression inside parentheses as normal and add the sum into the queue
            Then return back to the usual calculation
         */
        return calculate();
    }

    public int calculate() {
        int num = 0;
        char sign = '+';

        Deque<Integer> stack = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            char c = queue.poll();

            if (Character.isDigit(c)) {
                num = 10 * num + Integer.parseInt(c + "");
            } else {
                /* If meet left parentheses, handle it recursively */
                if (c == '(') {
                    num = calculate();
                }

                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }

                num = 0;
                sign = c;

                /*  If meet right parentheses, it means we should return from the recursion.
                    Be careful with the position of this check!
                    This should be done after we push the new number into the stack
                 */
                if (c == ')') {
                    break;
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
