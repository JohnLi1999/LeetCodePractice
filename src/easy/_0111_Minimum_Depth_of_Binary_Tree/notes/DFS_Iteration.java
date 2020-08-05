package easy._0111_Minimum_Depth_of_Binary_Tree.notes;

import utils.pair_node.Pair;
import utils.tree_node.TreeNode;

import java.util.LinkedList;

/*  Time complexity: O(N)
        Each node is visited exactly once and time complexity is O(N).
    Space complexity: O(N)
        In the worst case we could keep up to the entire tree,
        that results in O(N) space complexity.
 */
public class DFS_Iteration {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();

        if (root == null) {
            return 0;
        }
        else {
            stack.add(new Pair(root, 1));
        }

        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pollLast();
            root = current.getKey();
            int current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                min_depth = Math.min(min_depth, current_depth);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }

        return min_depth;
    }
}