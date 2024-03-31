/**

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.


Example 1:

Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6. 

Example 2:

Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 

Example 3:

Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.

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

    public ListNode reverse(ListNode head) {
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

    public int pairSum(ListNode head) {
        ListNode fast=head; 
        ListNode slow=head;
        while(fast.next.next!=null){     // Finding middle node (Left middle for even)
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev_right_half=reverse(slow.next); // Reversing the right half of the list
        slow.next=rev_right_half;   // Connecting the new reversed list after middle node
        ListNode p1=head; // First node
        ListNode p2=slow.next;  // First node after middle
        int max=Integer.MIN_VALUE;
        while(p2!=null){
            int x=p1.val+p2.val;    // Adding from first and after middle node
            p1=p1.next;
            p2=p2.next;
            if(x>max){
                max=x;
            }
        }
        return max;
    }
}
