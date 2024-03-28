/**

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){  // If the list is empty or it has 1 node
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode t1=odd;
        ListNode t2=even;
        while(t2!=null && t2.next!=null){       // If even is null or even.next is null
            t1.next=t2.next;            // Odd.next = Even.next
            t1=t1.next;
            t2.next=t1.next;            // Even.next = odd.next
            t2=t2.next;
        }
        t1.next=even;   // connecting odd next to the even start
        return odd;
    }
}
