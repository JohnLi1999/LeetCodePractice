package hard._0025_Reverse_Nodes_in_k_Grpup;

import org.junit.jupiter.api.Nested;
import utils.list_node.ListNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static hard._0025_Reverse_Nodes_in_k_Grpup.Solution.reverseKGroup;
import static hard._0025_Reverse_Nodes_in_k_Grpup.Solution.reverse;

class Tests {

    @Nested
    class TestReverseKGroup {
        @Test
        void test1() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {5, 4, 3, 2, 1});
            int k = 1;
            ListNode.printList(reverseKGroup(input, k)); // 1 -> 2 -> 3 -> 4 -> 5
        }

        @Test
        void test2() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {5, 4, 3, 2, 1});
            int k = 2;
            ListNode.printList(reverseKGroup(input, k)); // 2 -> 1 -> 4 -> 3 -> 5
        }

        @Test
        void test3() {
            ListNode input = new ListNode().arrayToListNodes(new int[] {5, 4, 3, 2, 1});
            int k = 3;
            ListNode.printList(reverseKGroup(input, k)); // 3 -> 2 -> 1 -> 4 -> 5
        }
    }

    @Nested
    class TestReverse {
        ListNode one = null;
        ListNode two = null;
        ListNode three = null;
        ListNode four = null;
        ListNode five = null;
        ListNode six = null;
        ListNode seven = null;
        ListNode eight = null;

        ListNode resetAllTestNodes() {
            one = new ListNode(1);
            two = new ListNode(2);
            three = new ListNode(3);
            four = new ListNode(4);
            five = new ListNode(5);
            six = new ListNode(6);
            seven = new ListNode(7);
            eight = new ListNode(8);

            one.next = two;
            two.next = three;
            three.next = four;
            four.next = five;
            five.next = six;
            six.next = seven;
            seven.next = eight;

            return one;
        }

        @Test
        void test1() {
            ListNode head = resetAllTestNodes();
            reverse(two, five);
            ListNode.printList(head); // 1 -> 2 -> 4 -> 3 -> 5 -> 6 -> 7 -> 8
        }

        @Test
        void test2() {
            ListNode head = resetAllTestNodes();
            reverse(two, seven);
            ListNode.printList(head); // 1 -> 2 -> 6 -> 5 -> 4 -> 3 -> 7 -> 8
        }

        @Test
        void test3() {
            ListNode head = resetAllTestNodes();
            reverse(two, null);
            ListNode.printList(head); // 1 -> 2 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3
        }

        @Test
        void test4() {
            ListNode head = resetAllTestNodes();
            reverse(one, null);
            ListNode.printList(head); // 1 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2
        }

        @Test
        void test5() {
            ListNode head = resetAllTestNodes();
            reverse(one, eight);
            ListNode.printList(head); // 1 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 8
        }

        @Test
        void test6() {
            ListNode head = resetAllTestNodes();
            reverse(one, two);
            ListNode.printList(head); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        }

        @Test
        void test7() {
            ListNode head = resetAllTestNodes();
            reverse(three, five);
            ListNode.printList(head); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
        }

        @Test
        void test8() {
            ListNode head = resetAllTestNodes();
            reverse(three, six);
            ListNode.printList(head); // 1 -> 2 -> 3 -> 5 -> 4 -> 6 -> 7 -> 8
        }
    }
}