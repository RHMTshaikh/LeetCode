/*
 * 23. Merge k Sorted Lists
Hard
Topics
Companies
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedList23 {
    public static void main(String[] args) {
        int[][] arr = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] list = new ListNode[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ListNode curr = new ListNode();
            list[i] = curr;
            for (int j = 0; j < arr[i].length; j++) {
                curr.next = new ListNode();
                curr = curr.next;
                curr.val = arr[i][j];
            }
            list[i] = list[i].next;
        }
        // System.out.println(list[0].next.val);

        MergeKSortedList23 s = new MergeKSortedList23();
        s.print(s.mergeKLists(list));
    }   
// }
// class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return (new ListNode[1])[0]; // this is actualy faster than returning null
        int left =0, right=lists.length-1;
        while (left < right) {
            ListNode currLeft = lists[left];
            ListNode currRight = lists[right];
            ListNode result;
            ListNode currResultNode = new ListNode();
            result = currResultNode;
        
            while (currLeft != null && currRight != null) {
                if (currLeft.val > currRight.val) {
                    currResultNode.next = new ListNode(currRight.val);
                    currRight = currRight.next;
                }else{
                    currResultNode.next = new ListNode(currLeft.val);
                    currLeft = currLeft.next;
                }
                currResultNode = currResultNode.next;
            }
            if(currLeft != null){
                currResultNode.next = currLeft;
            }else{
                currResultNode.next = currRight;
            }
            lists[left] = result.next;

            left++;
            right--;
        }

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return (new ListNode[1])[0]; // this is actualy faster than returning null

        for (int i = 1; i < lists.length; i++) {
            ListNode currNode1 = lists[0];
            ListNode currNode2 = lists[i];
            ListNode result;
            ListNode currResultNode = new ListNode();
            result = currResultNode;

            while (currNode1 != null && currNode2 != null) {
                if (currNode1.val > currNode2.val) {
                    // currResultNode.next = new ListNode(currNode2.val);
                    currResultNode.next = currNode2;
                    currNode2 = currNode2.next;
                }else{
                    // currResultNode.next = new ListNode(currNode1.val);
                    currResultNode.next = currNode1;
                    currNode1 = currNode1.next;
                }
                currResultNode = currResultNode.next;
            }
            if(currNode1 != null){
                currResultNode.next = currNode1;
            }else{
                currResultNode.next = currNode2;
            }
            lists[0] = result.next;
        }
        return lists[0];
    }

    void print(ListNode l){
        ListNode curr = l;
        while (curr != null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
    }
}
