package easy._0111_Minimum_Depth_of_Binary_Tree.notes;

import utils.pair_node.Pair;
import utils.tree_node.TreeNode;

import java.util.LinkedList;

/*  Time complexity: O(N)
        In the worst case for a balanced tree we need to visit all nodes
        level by level up to the tree height, that excludes the bottom level only.
        This way we visit N/2 nodes, and thus the time complexity is O(N).
    Space complexity: O(N)
        Is the same as time complexity here O(N).
 */
public class BFS_Iteration {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }
        else {
            queue.add(new Pair(root, 1));
        }

        int current_depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            root = current.getKey();
            current_depth = current.getValue();
            if ((root.left == null) && (root.right == null)) {
                break;
            }
            if (root.left != null) {
                queue.add(new Pair(root.left, current_depth + 1));
            }
            if (root.right != null) {
                queue.add(new Pair(root.right, current_depth + 1));
            }
        }

        return current_depth;
    }
}
