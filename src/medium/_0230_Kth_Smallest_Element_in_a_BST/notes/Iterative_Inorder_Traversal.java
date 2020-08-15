package medium._0230_Kth_Smallest_Element_in_a_BST.notes;

import utils.tree_node.TreeNode;

import java.util.LinkedList;

/*  Time complexity: O(H + k)
        Where H is a tree height.
        This complexity is defined by the stack, which contains at least H + k elements,
        since before starting to pop out one has to go down to a leaf.
        This results in O(logN + k) for the balanced tree and
        O(N + k) for completely unbalanced tree with all the nodes in the left subtree.
    Space complexity: O(H)
        To keep the stack, where H is a tree height.
        That makes O(N) in the worst case of the skewed tree, and
        O(logN) in the average case of the balanced tree.
 */
public class Iterative_Inorder_Traversal {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}