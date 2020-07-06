package medium._0022_Generate_Parentheses.notes;

import java.util.ArrayList;
import java.util.List;

public class Brute_Force {
    /*  Time Complexity: O(2^{2n} * n)
            For each of 2^{2n} sequences, we need to create and validate the sequence, which takes O(n) work.
        Space Complexity: O(2^{2n} * n)
            Naively, every sequence could be valid.
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}