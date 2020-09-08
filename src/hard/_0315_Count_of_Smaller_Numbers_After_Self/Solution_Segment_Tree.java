package hard._0315_Count_of_Smaller_Numbers_After_Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*  https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    Time Complexity: O(n*log(n))
        It takes O(n) time to build the tree, where n is the length of the input array
        It takes O(log(n)) time to insert of get the count of smaller numbers of a value,
        and we need to apply both operations on every element in the array.
        Overall, it has a O(n*log(n)) time complexity
    Space Complexity: O(n)
        Need to store all the elements in the segment tree
 */
public class Solution_Segment_Tree {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        SegmentTree tree = new SegmentTree(min, max);
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            tree.insert(num); // O(log(n))
            result[i] = tree.getCountOfSmallerNumbers(min, num - 1); // O(log(n))
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}

class SegmentTree {
    private SegmentTreeNode root;

    public SegmentTree(int start, int end) {
        root = buildTree(start, end);
    }

    public void insert(int value) {
        increaseCount(root, value);
    }

    public int getCountOfSmallerNumbers(int i, int j) {
        return getCountInRange(root, i, j);
    }

    private SegmentTreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end);

        if (start < end) {
            int mid = start + (end - start) / 2;
            node.left = buildTree(start, mid);
            node.right = buildTree(mid + 1, end);
        }

        return node;
    }

    private void increaseCount(SegmentTreeNode root, int value) {
        if (root == null || value < root.start || value > root.end) {
            return;
        }

        root.count += 1;
        increaseCount(root.left, value);
        increaseCount(root.right, value);
    }

    private int getCountInRange(SegmentTreeNode root, int i, int j) {
        if (root == null || i > root.end || j < root.start) {
            return 0;
        }

        if (i <= root.start && j >= root.end) {
            return root.count;
        }

        int leftCount = getCountInRange(root.left, i, j);
        int rightCount = getCountInRange(root.right, i, j);
        return leftCount + rightCount;
    }
}

class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public int count;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


