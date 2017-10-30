// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val + l2.val) % 10);
        ListNode point = result;
        int carry = (l1.val + l2.val) / 10;
        while (l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            point.next = new ListNode((l1.val + l2.val + carry) % 10 );
            carry = (l1.val + l2.val+ carry) / 10;
            point = point.next;
        }
        while (l1.next == null && l2.next != null){
            l2 = l2.next;
            point.next = new ListNode( (l2.val + carry) % 10);
            carry = (l2.val+ carry) / 10;
            point = point.next;
        }
        while (l2.next == null && l1.next != null){
            l1 = l1.next;
            point.next = new ListNode( (l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            point = point.next;
        }
        if (carry != 0){
            point.next = new ListNode(carry);
            point = point.next;
        }
        return result;
    }
}
