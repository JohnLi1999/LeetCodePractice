package easy._0111_Minimum_Depth_of_Binary_Tree;

import org.junit.jupiter.api.Test;
import utils.tree_node.TreeNode;

import static easy._0111_Minimum_Depth_of_Binary_Tree.Solution.minDepth;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void test1() {
        TreeNode root = TreeNode.arrayToTree(new Integer[] {3, 9, 20, null, null, 15, 7});
        assertEquals(2, minDepth(root));
    }

    @Test
    void test2() {
        TreeNode root = TreeNode.arrayToTree(new Integer[] {1, 2});
        assertEquals(2, minDepth(root));
    }
}