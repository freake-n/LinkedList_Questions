/**

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


//                                                                      Approach : 1  (Recursive)

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){    // Base case
            return head;
        }
        ListNode newhead=reverseList(head.next); // Assuming the rest of the list is reversed
        head.next.next=head; // Reversing the connection with the next node
        head.next=null;
        return newhead;
    }
}


//                                                                      Approach : 2 (Iterative) -> Recommended

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null; // Previous pointer
        ListNode agla=null; // Next pointer
        ListNode curr=head; // Current pointer
        while(curr!=null){          // Previous - Current - Next  
            agla=curr.next; 
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        return prev;
    }
}
