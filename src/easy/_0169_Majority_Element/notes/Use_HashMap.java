package easy._0169_Majority_Element.notes;

import java.util.HashMap;
import java.util.Map;

public class Use_HashMap {
    /*  Time complexity: O(n)
            We iterate over nums once and make a constant time HashMap insertion on each iteration.
            Therefore, the algorithm runs in O(n) time.
        Space complexity: O(n)
            At most, the HashMap can contain (n - ⌊ n/2 ⌋) associations, so it occupies O(n) space.
            This is because an arbitrary array of length n can contain n distinct values,
            but nums is guaranteed to contain a majority element, which will
            occupy (at minimum) (⌊ n/2 ⌋ + 1) array indices. Therefore, (⌊ n/2 ⌋ + 1) indices
            can be occupied by distinct, non-majority elements (plus 1 for the majority element itself),
            leaving us with (at most) (n - ⌊ n/2 ⌋) distinct elements.
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }
}
