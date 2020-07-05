package easy._0104_Maximum_Depth_of_Binary_Tree;

import utils.tree_node.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /*  https://leetcode.com/problems/maximum-depth-of-binary-tree/
        Time complexity: O(N)
            We visit each node exactly once, thus the time complexity is O(N),
            where N is the number of nodes.
        Space complexity: O(N) worst, O(log(N)) best
            In the worst case, the tree is completely unbalanced,
            e.g. each node has only left child node, the recursion call would occur N times
            (the height of the tree), therefore the storage to keep the call stack would be O(N).
            But in the best case (the tree is completely balanced),
            the height of the tree would be log(N).
            Therefore, the space complexity in this case would be O(log(N)).
     */
    public static int maxDepth_Recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth_Recursive(root.left);
        int rightMaxDepth = maxDepth_Recursive(root.right);

        return 1 + (leftMaxDepth > rightMaxDepth ? leftMaxDepth : rightMaxDepth);
    }

    /*  Time complexity: O(N)
        Space complexity: O(N) worst, O(log(N)) best
            In the worst case, the tree is completely unbalanced,
            e.g. each node has only left child node, the recursion call would occur N times
            (the height of the tree), therefore the storage to keep the call stack would be O(N).
            But in the best case (the tree is completely balanced),
            the height of the tree would be log(N).
            Therefore, the space complexity in this case would be O(log(N)).
     */
    public static int maxDepth_Iterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int level_length = queue.size();

            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }
}
