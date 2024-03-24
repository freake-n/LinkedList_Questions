/**

Remove Nth Node From End of List

Hint: Given the head of a linked list, remove the nth node from the end of the list and return its head.
  
Example 1:
  
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode slow=head;

        for(int i=1;i<=n;i++){
            fast=fast.next;
        }
        if(fast==null){   // If the nth node given is same as the size of the list, fast -> null
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
