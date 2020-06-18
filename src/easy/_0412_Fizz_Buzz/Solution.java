package easy._0412_Fizz_Buzz;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    /*  https://leetcode.com/problems/fizz-buzz/
        Time Complexity: O(n)
        Space Complexity: O(1)
     */
    public static List<String> fizzBuzz(int n) {
        /*  Use a hash map to store all FizzBuzz mappings.
            TreeMap is used since we want the keySet is sorted in ascending order
         */
        Map<Integer, String> map = new TreeMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");

        // Initialize the result list
        List<String> result = new LinkedList<>();

        for (int num = 1; num <= n; num++) {
            String str = "";

            for (Integer key : map.keySet()) {
                /*  If the num is divisible by the key,
                    then add the corresponding string mapping to current str
                 */
                if (num % key == 0) {
                    str = str + map.get(key);
                }
            }

            if (str.equals("")) {
                // If not divisible by any of the keys, then add the number itself
                str += num;
            }

            // Append the current answer str to the result list
            result.add(str);
        }

        return result;
    }
}
