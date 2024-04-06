/**

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null || (head.next==null && head.val==val))
            return null;
        ListNode a=new ListNode(100);   // Dummy node
        ListNode t=a;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==val){
                temp=temp.next;
                continue;   // Skipping node with value same as target
            }
            else{
                ListNode x=new ListNode(temp.val);  // New node creation for adding
                t.next=x;
                t=x;
            }
            temp=temp.next;
        }
        return a.next;  // returning new node by removing the dummy node
    }
}
