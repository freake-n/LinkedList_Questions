/**

Given the head of a singly linked list, return true if it is palindrome or false otherwise.
 
Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false

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

//                                              Approach : 1 (Using concept of reverse list and middle of list) -> Recommended

//    1 -> 2 -> 2 -> 1     ==>     1 -> 2 -> 1 -> 2    (Changing the list to check half)

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

    public boolean isPalindrome(ListNode head) {
        ListNode fast=head; 
        ListNode slow=head;
        while(fast.next!=null && fast.next.next!=null){     // Finding middle node (Left middle for even)
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev_right_half=reverse(slow.next); // Reversing the right half of the list
        slow.next=rev_right_half;   // Connecting the new reversed list after middle node
        ListNode p1=head; // First node
        ListNode p2=slow.next;  // First node after middle
        while(p2!=null){
            if(p1.val!=p2.val){     // If does not matches
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
}


//                                                    Approach : 2 (By duplicating list)


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

    public boolean isPalindrome(ListNode head) {
        ListNode temp=head;
        ListNode dup=new ListNode(100); // Declaring a node with dummy value
        ListNode d=dup;
        while(temp!=null){  // Duplicating the given list
            ListNode n=new ListNode(temp.val);
            temp=temp.next;
            d.next=n;
            d=d.next;
        }
        dup=reverse(dup.next);  // Reversing the duplicated list
        ListNode p1=head;
        ListNode p2=dup;

        while(p1!=null){
            if(p1.val!=p2.val){     // If does not matches
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
}
