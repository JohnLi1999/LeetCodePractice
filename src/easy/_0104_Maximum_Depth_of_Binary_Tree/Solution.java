package easy._0104_Maximum_Depth_of_Binary_Tree;

import utils.tree_node.TreeNode;

public class Solution {
    /*  https://leetcode.com/problems/maximum-depth-of-binary-tree/
        Time complexity: O(N)
            We visit each node exactly once, thus the time complexity is O(N),
            where N is the number of nodes.
        Space complexity: O(N) worst, O(log(N)) best
            In the worst case, the tree is completely unbalanced,
            e.g. each node has only left child node, the recursion call would occur N times
            (the height of the tree), therefore the storage to keep the call stack would
            be O(N). But in the best case (the tree is completely balanced),
            the height of the tree would be log(N).
            Therefore, the space complexity in this case would be O(log(N)).
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return 1 + (leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth);
    }
}
