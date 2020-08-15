package medium._0230_Kth_Smallest_Element_in_a_BST.notes;

import utils.tree_node.TreeNode;

import java.util.ArrayList;

/*  Time complexity: O(N)
        To build a traversal.
    Space complexity: O(N)
        To keep an inorder traversal.
 */
public class Recursive_Inorder_Traversal {
    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
}