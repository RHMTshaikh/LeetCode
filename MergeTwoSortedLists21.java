/*
 * 21. Merge Two Sorted Lists
Easy
Topics
Companies
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
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergeTwoSortedLists21 {
    
     
    public static void main(String[] args) {
        MergeTwoSortedLists21 m = new MergeTwoSortedLists21();
        ListNode head = new ListNode();
        if (head != null) {
            System.out.println("null");
            head.val =8;
            System.out.println(head.val);
        }
        head = head.next;
        head = head.next;

        
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode current = head;

            int num1, num2;
            while (list1 != null || list2 != null) {
                num1=101; num2=101;
                if(list1 != null){
                    num1 = list1.val;
                }
                if (list2 != null) {
                    num2 = list2.val;
                }
                if (num1 < num2) {
                    current.next = new ListNode();
                    current = current.next;
                    current.val = num1;
                    list1 = list1.next;
                } else {
                    current.next = new ListNode();
                    current = current.next;
                    current.val = num2;
                    list2 = list2.next;                    
                }
            }
            return head.next;
        }
    }
    
}
