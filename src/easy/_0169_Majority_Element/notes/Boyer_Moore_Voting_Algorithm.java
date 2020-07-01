package easy._0169_Majority_Element.notes;

public class Boyer_Moore_Voting_Algorithm {
    /*  Time complexity: O(n)
            Boyer-Moore performs constant work exactly n times, so the algorithm runs in linear time.
        Space complexity: O(1)
            Boyer-Moore allocates only constant additional memory.
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
