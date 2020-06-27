package medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import static medium._0236_Lowest_Common_Ancestor_of_a_Binary_Tree.Solution.lowestCommonAncestor;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        TreeNode input = TreeNode.arrayToTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        int expectedResult = 3;
        assertEquals(expectedResult, lowestCommonAncestor(input, new TreeNode(5), new TreeNode(1)).val);
    }

    @Test
    void test2() {
        TreeNode input = TreeNode.arrayToTree(new Integer[] {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        int expectedResult = 5;
        assertEquals(expectedResult, lowestCommonAncestor(input, new TreeNode(5), new TreeNode(4)).val);
    }
}