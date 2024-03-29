/**

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;

        while(temp!=null && temp.next!=null){
             // If the current node's value is equal to the next node's value
            if (temp.val == temp.next.val) {
                // Skip the next node by setting the current node's next pointer to point to the node after the next node
                temp.next = temp.next.next;
            } 
            else {
                // If the current node's value is different from the next node's value, move to the next node
                temp = temp.next;
            }
        }
        return head;
    }
}
