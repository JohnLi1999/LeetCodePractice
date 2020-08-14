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
public class Stack_Pair {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Pair> stack = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek().value) {
                Pair pair = stack.pop();
                result[pair.index] = i - pair.index;
            }
            stack.push(new Pair(T[i], i));
        }

        return result;
    }
}

class Pair {
    public int value;
    public int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}