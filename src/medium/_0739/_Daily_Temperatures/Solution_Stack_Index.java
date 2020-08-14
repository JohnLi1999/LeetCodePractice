package medium._0739._Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Deque;

/*  https://leetcode.com/problems/daily-temperatures/
    Time Complexity: O(N)
        Where N is the length of T
        Each index gets pushed and popped at most once from the stack.
    Space Complexity: O(N).
        The size of the stack can go up to N if all the temperatures are the same
 */
public class Solution_Stack_Index {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int [T.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
