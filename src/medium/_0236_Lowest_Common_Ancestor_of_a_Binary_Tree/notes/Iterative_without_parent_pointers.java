package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree.notes;

import utils.tree_node.TreeNode;

import java.util.Stack;

/*  Time Complexity: O(N)
        Where N is the number of nodes in the binary tree.
        In the worst case we might be visiting all the nodes of the binary tree.
        The advantage of this approach is that we can prune backtracking.
        We simply return once both the nodes are found.
    Space Complexity: O(N)
        In the worst case the space utilized by stack would be N
        since the height of a skewed binary tree could be N.
 */
public class Iterative_without_parent_pointers {
    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        // Initialize the stack with the root node.
        stack.push(new Pair<>(root, Iterative_without_parent_pointers.BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != Iterative_without_parent_pointers.BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == Iterative_without_parent_pointers.BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<>(child_node, Iterative_without_parent_pointers.BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }
}

class Pair<T, E> {
    private T t;
    private E e;

    public Pair(T t, E e) {
        this.t = t;
        this.e = e;
    }

    public T getKey() {
        return t;
    }

    public E getValue() {
        return e;
    }
}