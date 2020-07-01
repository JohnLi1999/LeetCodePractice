package easy._0169_Majority_Element.notes;

public class Divide_and_Conquer {
    /*  Time complexity: O(n*log(n))
            Each recursive call to majority_element_rec performs two recursive calls on sub-slices
            of size (n/2) and two linear scans of length n.
            Therefore, the time complexity of the divide & conquer approach can be represented by
            the following recurrence relation:
                T(n) = 2T(n/2) + 2*n
            By the master theorem, the recurrence satisfies case 2, so the complexity can be analyzed as such:
                T(n) = Θ(n^{log_b(a)} * log(n))
                     = Θ(n^{log_2(2)} * log(n))
                     = Θ(n*log(n))
        Space complexity: O(log(n))
            Although the divide & conquer does not explicitly allocate any additional memory,
            it uses a non-constant amount of additional memory in stack frames due to recursion.
            Because the algorithm "cuts" the array in half at each level of recursion,
            it follows that there can only be O(log(n)) "cuts" before the base case of 1 is reached.
            It follows from this fact that the resulting recursion tree is balanced,
            and therefore all paths from the root to a leaf are of length O(log(n)).
            Because the recursion tree is traversed in a depth-first manner,
            the space complexity is therefore equivalent to the length of the longest path,
            which is, of course, O(log(n)).
     */
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
