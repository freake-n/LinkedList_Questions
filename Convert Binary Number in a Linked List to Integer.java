/**

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.
The most significant bit is at the head of the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:

Input: head = [0]
Output: 0

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

//                                                                  Approach - 1 


class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        while (head != null) {
            decimalValue = decimalValue * 2 + head.val; // Update the decimal value by shifting it left by 1 bit and adding the current node's value.
            head = head.next;
        }
        return decimalValue;
    }
}


//                                                                  Approach - 2 (Recommended)


class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode p1 = head;
        int n = 0;

        while(p1 != null){
            n++;  // Calculating length of list
            p1 = p1.next;
        }

        int sum = 0;
        p1 = head;

        while(p1 != null){
            sum = sum + p1.val * (int)Math.pow(2, --n);  // Converting to binary
            p1 = p1.next;
        }

        return sum;
    }
}
