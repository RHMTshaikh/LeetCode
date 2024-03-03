/*
2. Add Two Numbers
Attempted
Medium
Topics
Companies
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class AddTwoNumbers2{
    public static void main(String[] args) {
        ListNode  a = new ListNode();
        if (a != null) {
            System.out.println("not null");
        }
    }
    
}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode();
        ListNode currNode = head;
        int carry= 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            currNode.next = new ListNode( sum%10 );
            currNode = currNode.next; // adding value to one node ahead of head
            carry = sum/10;
        }
        return head.next;
    }
}
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode head =  new ListNode();
//         int sum = l1.val + l2.val;
//         head.val = sum%10;
//         int carry = sum/10;
//         ListNode currNode = head;
//         while(l1.next != null && l2.next != null){
//             l1 = l1.next;
//             l2 = l2.next;
//             sum = l1.val + l2.val + carry;
//             carry = sum/10;
//             currNode.next = new ListNode();
//             currNode = currNode.next;
//             currNode.val = sum%10;
//         }
//         if (l1.next != null) {
//             l1 = l1.next;
//             sum = l1.val + carry;
//             carry = sum/10;
//             currNode.next = new ListNode();
//             currNode = currNode.next;
//             currNode.val = sum%10;
//             while(l1.next != null){
//                 l1 = l1.next;
//                 sum = l1.val + carry;
//                 carry = sum/10;
//                 currNode.next = new ListNode();
//                 currNode = currNode.next;
//                 currNode.val = sum%10;
//             }
//         } 
//         if(l2.next != null){
//             l2 = l2.next;
//             sum = l2.val + carry;
//             carry = sum/10;
//             currNode.next = new ListNode();
//             currNode = currNode.next;
//             currNode.val = sum%10;
//             while(l2.next != null){
//                 l2 = l2.next;
//                 sum = l2.val + carry;
//                 carry = sum/10;
//                 currNode.next = new ListNode();
//                 currNode = currNode.next;
//                 currNode.val = sum%10;
//             }
//         }
//         if(carry != 0){
//             currNode.next = new ListNode();
//             currNode = currNode.next;
//             currNode.val = carry;
//         }
//         return head;
//     }
// }
