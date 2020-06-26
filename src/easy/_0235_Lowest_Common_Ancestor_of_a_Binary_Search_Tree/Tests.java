package easy._0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import static org.junit.jupiter.api.Assertions.*;
import static easy._0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.Solution.lowestCommonAncestor_Recursive;
import static easy._0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.Solution.lowestCommonAncestor_Iterative;

class Tests {

    @Nested
    class Recursive {
        @Test
        void test1() {
            TreeNode input = TreeNode.arrayToTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
            int expectedResult = 6;
            assertEquals(expectedResult, lowestCommonAncestor_Recursive(input, new TreeNode(2), new TreeNode(8)).val);
        }

        @Test
        void test2() {
            TreeNode input = TreeNode.arrayToTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
            int expectedResult = 2;
            assertEquals(expectedResult, lowestCommonAncestor_Recursive(input, new TreeNode(2), new TreeNode(4)).val);
        }
    }

    @Nested
    class Iterative {
        @Test
        void test1() {
            TreeNode input = TreeNode.arrayToTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
            int expectedResult = 6;
            assertEquals(expectedResult, lowestCommonAncestor_Iterative(input, new TreeNode(2), new TreeNode(8)).val);
        }

        @Test
        void test2() {
            TreeNode input = TreeNode.arrayToTree(new Integer[] {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
            int expectedResult = 2;
            assertEquals(expectedResult, lowestCommonAncestor_Iterative(input, new TreeNode(2), new TreeNode(4)).val);
        }
    }
}