/* * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } */
class Solution {
   public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        // Find the middle of the list
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Split the list into two halves
        // Recursively split and sort both halves
        left = sortList(left);
        right = sortList(right);
        // Merge the sorted halves
        return merge(left, right);
    }
    // Function to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // Function to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;// connects the remaining portion of left list to tail.
        } else {
            tail.next = right;
        }
        return dummy.next; //it eliminates the first inserted  0th element.
    }}
