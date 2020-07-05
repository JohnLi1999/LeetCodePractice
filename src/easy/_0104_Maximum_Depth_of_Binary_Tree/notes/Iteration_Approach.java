package easy._0104_Maximum_Depth_of_Binary_Tree.notes;

import utils.tree_node.TreeNode;

import java.util.LinkedList;

/*  Time complexity: O(N)
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
public class Iteration_Approach {
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}
