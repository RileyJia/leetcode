// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode point = result;
        
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                point.next = new ListNode(l1.val);
                point = point.next;
                l1 = l1.next;

            } else if (l1.val > l2.val){
                point.next = new ListNode(l2.val);
                point = point.next;
                l2 = l2.next;

            } else {
                point.next = new ListNode(l1.val);
                point.next.next = new ListNode(l2.val);
                
                point = point.next.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        
        if (l1 != null) {
            point.next = l1;
        }
        
        if (l2!= null){
            point.next = l2;
        }

        return result.next;
    }
}
