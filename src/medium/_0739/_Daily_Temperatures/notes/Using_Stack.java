package medium._0739._Daily_Temperatures.notes;

import java.util.Stack;

/*  Time Complexity: O(N)
        Where N is the length of T and W is the number of allowed values for T[i].
        Each index gets pushed and popped at most once from the stack.
    Space Complexity: O(W).
        The size of the stack is bounded as it represents strictly increasing temperatures.
 */
public class Using_Stack {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
