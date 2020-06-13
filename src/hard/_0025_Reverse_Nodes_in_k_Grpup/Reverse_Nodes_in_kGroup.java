package hard._0025_Reverse_Nodes_in_k_Grpup;

public class Reverse_Nodes_in_kGroup {
    public static void main(String[] args) {
        ListNode list = create(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        print(list);
        print(reverseKGroup(list, 4));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        do {
            ListNode[] arr = new ListNode[k];

            int count = 1;
            while (count < k && current.next != null) {
                arr[count - 1] = current;
                current = current.next;
                count++;
            }
            if (count == k) {
                arr[count - 1] = current;
                current = current.next;

                for (int i = 0; i < arr.length; i++) {
                    if (i == 0) {
                        arr[i].next = arr[arr.length - 1].next;
                        continue;
                    }
                    arr[i].next = arr[i - 1];
                }

                if (prev == null) {
                    head = arr[arr.length - 1];
                } else {
                    prev.next = arr[arr.length - 1];
                }

                prev = arr[0];
            } else {
                break;
            }
        } while (current != null);

        return head;
    }

    public static ListNode create(int[] arr) {
        if (arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static void print(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
