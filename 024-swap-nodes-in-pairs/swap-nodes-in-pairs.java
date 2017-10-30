//
// Given a linked list, swap every two adjacent nodes and return its head.
//
//
//
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//
//
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode point1 = head;
        ListNode point2;
        int val1,val2;

        while (point1.next != null ) {
            point2 = point1.next;
            val1 = point1.val;
            val2 = point2.val;

            point1.val = val2;
            point2.val = val1;
            if (point2.next == null) break;
            point1 = point2.next;
        }

        return head;
    }
}
