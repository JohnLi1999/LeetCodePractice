package medium._0091_Decode_Ways;

/*  Time Complexity: O(2^N)
        We do not store temporal results.
        So it takes exponential time.
    Space Complexity: O(N)
        We have a character array to store the string.
        The recursion stack would be equal to the length of the string.
 */
public class Solution_Pure_Recursion {
    public int numDecodings(String s) {
        char[] code = s.toCharArray();
        return decode(code, 0);
    }

    private int decode(char[] code, int index) {
        if (index >= code.length) {
            return 1;
        }

        int count = 0;
        char curr = code[index];
        if (curr != '0') {
            count = decode(code, index + 1);
        }

        if (index < code.length - 1) {
            char next = code[index + 1];
            if (curr == '1' || (curr == '2' && next <= '6')) {
                count += decode(code, index + 2);
            }
        }

        return count;
    }
}
