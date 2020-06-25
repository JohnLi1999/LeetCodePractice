package medium._0098_Validate_Binary_Search_Tree;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import static org.junit.jupiter.api.Assertions.*;
import static medium._0098_Validate_Binary_Search_Tree.Solution.isValidBST_Recursion;
import static medium._0098_Validate_Binary_Search_Tree.Solution.isValidBST_InOrderTraverse;
import static medium._0098_Validate_Binary_Search_Tree.Solution.isValidBST_InOrderTraverse_Iterative;

class Tests {

    @Nested
    class Recursion {
        @Test
        void test1() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {5, 1, 4, null, null, 3, 6});
            TreeNode.inOrderTraverse(root); // 1 5 3 4 6
            assertFalse(isValidBST_Recursion(root));
        }

        @Test
        void test2() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {2, 1, 3});
            TreeNode.inOrderTraverse(root); // 1 2 3
            assertTrue(isValidBST_Recursion(root));
        }

        @Test
        void test3() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {1, 1});
            TreeNode.inOrderTraverse(root); // 1 1
            assertFalse(isValidBST_Recursion(root));
        }

        @Test
        void test4() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {10, 5, 15, null, null, 6, 20});
            TreeNode.inOrderTraverse(root); // 5 10 6 15 20
            assertFalse(isValidBST_Recursion(root));
        }

        @Test
        void test5() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {Integer.MIN_VALUE});
            TreeNode.inOrderTraverse(root); // -2147483648
            assertTrue(isValidBST_Recursion(root));
        }
    }

    @Nested
    class InOrderTraverse {
        @Test
        void test1() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {5, 1, 4, null, null, 3, 6});
            TreeNode.inOrderTraverse(root); // 1 5 3 4 6
            assertFalse(isValidBST_InOrderTraverse(root));
        }

        @Test
        void test2() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {2, 1, 3});
            TreeNode.inOrderTraverse(root); // 1 2 3
            assertTrue(isValidBST_InOrderTraverse(root));
        }

        @Test
        void test3() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {1, 1});
            TreeNode.inOrderTraverse(root); // 1 1
            assertFalse(isValidBST_InOrderTraverse(root));
        }

        @Test
        void test4() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {10, 5, 15, null, null, 6, 20});
            TreeNode.inOrderTraverse(root); // 5 10 6 15 20
            assertFalse(isValidBST_InOrderTraverse(root));
        }

        @Test
        void test5() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {Integer.MIN_VALUE});
            TreeNode.inOrderTraverse(root); // -2147483648
            assertTrue(isValidBST_InOrderTraverse(root));
        }
    }

    @Nested
    class InOrderTraverse_Iterative {
        @Test
        void test1() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {5, 1, 4, null, null, 3, 6});
            TreeNode.inOrderTraverse(root); // 1 5 3 4 6
            assertFalse(isValidBST_InOrderTraverse_Iterative(root));
        }

        @Test
        void test2() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {2, 1, 3});
            TreeNode.inOrderTraverse(root); // 1 2 3
            assertTrue(isValidBST_InOrderTraverse_Iterative(root));
        }

        @Test
        void test3() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {1, 1});
            TreeNode.inOrderTraverse(root); // 1 1
            assertFalse(isValidBST_InOrderTraverse_Iterative(root));
        }

        @Test
        void test4() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {10, 5, 15, null, null, 6, 20});
            TreeNode.inOrderTraverse(root); // 5 10 6 15 20
            assertFalse(isValidBST_InOrderTraverse_Iterative(root));
        }

        @Test
        void test5() {
            TreeNode root = TreeNode.arrayToTree(new Integer[] {Integer.MIN_VALUE});
            TreeNode.inOrderTraverse(root); // -2147483648
            assertTrue(isValidBST_InOrderTraverse_Iterative(root));
        }
    }
}