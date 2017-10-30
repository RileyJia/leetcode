// Given a linked list, remove the nth node from the end of list and return its head.
//
//
// For example,
//
//
//    Given linked list: 1->2->3->4->5, and n = 2.
//
//    After removing the second node from the end, the linked list becomes 1->2->3->5.
//
//
//
// Note:
// Given n will always be valid.
// Try to do this in one pass.
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1 ||head.next == null) return null;
        ListNode point = head;
        ListNode end = head;
        int len = 0;

        while ( end != null ){
            len++;
            end = end.next;
        }

        n = len - n;


        if (n == 0) return head.next;

        for (int i = 0; i < n - 1; i++) {
            point = point.next;
        }
        point.next = point.next.next;

        return head;   
    }
}
