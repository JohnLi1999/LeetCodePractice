package easy._0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.round_2;

import utils.tree_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNode.arrayToTree(new Integer[] {6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode result = s.lowestCommonAncestor(root, p, q);

        System.out.println(result.val);
    }

    /*  Better way
        Time complexity: O(N) in the worst case, O(log(n)) if the tree is balanced
        Space complexity: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*  Core idea:
                Start from the top level (the root), the lowest common ancestor (lca)
                of node p, and node q must be the first node that is
                            p < lca < q OR q < lca < p
         */

        TreeNode current = root;

        while (current != null) {
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    /* my way: search and compare
        Time complexity: O(d), d for depth of the tree
        Space complexity: O(d), d for depth of the tree
     */
//    List<TreeNode> list1 = new ArrayList<>();
//    List<TreeNode> list2 = new ArrayList<>();
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        search(root, p, list1);
//        search(root, q, list2);
//
//        for (int i = list1.size() - 1; i >= 0; i--) {
//            if (list2.contains(list1.get(i))) {
//                return list1.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    public void search(TreeNode root, TreeNode target, List<TreeNode> result) {
//        if (root == null) {
//            return;
//        }
//
//        if (root.val == target.val) {
//            result.add(root);
//            return;
//        }
//
//        result.add(root);
//
//        if (root.val > target.val) {
//            search(root.left, target, result);
//        } else {
//            search(root.right, target, result);
//        }
//    }
}
