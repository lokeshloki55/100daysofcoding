/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode prev = null, curr = head, next;
        int leftTemp = left;

        // Traverse until we reach the left position
        while (leftTemp != 1) {
            leftTemp--;
            prev = curr;
            curr = curr.next;
        }

        ListNode connection = prev; // Node before the reversal starts
        ListNode tail = curr;  // First node in the reversed sublist
        int rightTemp = right - left;

        // Reverse the nodes between left and right
        while (rightTemp != -1) {
            rightTemp--;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

       
        if (connection != null) 
            connection.next = prev; // `prev` is now the new head of the reversed sublist
        else 
            head = prev; // If `left == 1`, `prev` is the new head

        tail.next = curr; // Connect tail to the node after `right`

        return head;
    }

  
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
       
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int left = 2, right = 4;
        Solution solution = new Solution();
        head = solution.reverseBetween(head, left, right);

        System.out.println("Reversed List (Between positions " + left + " and " + right + "):");
        printList(head);
    }
}
