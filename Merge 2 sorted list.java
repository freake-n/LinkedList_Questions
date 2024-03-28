/**

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode a=new ListNode(100);       // Dummy node to make merge operation easier
        ListNode t=a;
        ListNode t1=list1;
        ListNode t2=list2;

        while(t1!=null && t2!=null){
            if(t1.val<=t2.val){     // If list1 value is smaller or equal to list2 value
                t.next=t1;
                t=t1;
                t1=t1.next;
            }
            else{
                t.next=t2;
                t=t2;
                t2=t2.next;
            }
        }
        
        if(t1==null){       // If list1 ends before list2
            t.next=t2;
        }
        else{               // If list2 ends before list1
            t.next=t1;
        }

        return a.next;      // Returning the head after merging and removing the dummy value
    }
}
