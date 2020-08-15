package medium._0230_Kth_Smallest_Element_in_a_BST;

import utils.tree_node.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*  https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    Time complexity: O(H + k)
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
public class Iterative_Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int count = 0;
        int result;

        while (true) {
            // Add left children into the stack until reach the end
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            /*  Assign the root to the top element removed from the stack and increase the counter.
                Since we remove the previous element from the stack, we won't re-iterate the node two times  */
            root = stack.pop();
            count++;

            // If the element is the kth element in the tree, then return its value
            if (count == k) {
                result = root.val;
                break;
            }

            // Start searching the right children
            root = root.right;
        }

        return result;
    }
}
