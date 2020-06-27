package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree.notes;

import utils.tree_node.TreeNode;

import java.util.*;

/*  Time Complexity: O(N)
        Where NN is the number of nodes in the binary tree.
        In the worst case we might be visiting all the nodes of the binary tree.
    Space Complexity: O(N)
        In the worst case space utilized by the stack, the parent pointer dictionary and the ancestor set,
        would be NN each, since the height of a skewed binary tree could be N.
 */
public class Iterative_using_parent_pointers {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);

        return q;
    }
}