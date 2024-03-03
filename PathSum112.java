/*
 * 112. Path Sum
Easy
Topics
Companies
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class PathSum112{
    public static void main(String[] args) {
        
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        // Link the nodes to form the tree structure
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node4.left = node7;
        node4.right = node8;

        node6.right = node9;

        PathSum112 p = new PathSum112();
        try {
            // System.out.println(p.hasPathSum(node1, 22));
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        
    }
}


class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum){
        MyStack stack = new MyStack();
        if (root != null) {
            stack.push(root);
        }else{
            return false;
        }
        return hasPathSum(targetSum, stack);
    }
    
    boolean hasPathSum(int targetSum, MyStack stack){
        if (stack.isEmpty()) {
            return false;
        }
        TreeNode currRoot = stack.pop();
        if (currRoot.left == null && currRoot.right == null) {
            if (currRoot.val == targetSum) {
                return true;
            }
        }
        if (currRoot.left != null) {
            currRoot.left.val += currRoot.val;
            stack.push(currRoot.left);
        }
        if (currRoot.right != null) {
            currRoot.right.val += currRoot.val;
            stack.push(currRoot.right);
        }
        return hasPathSum(targetSum, stack);
        
    }
    class MyStack{
        Node topNode, nextNode;
        class Node{
            TreeNode element;
            Node next;
        }
        boolean isEmpty(){
            if (topNode == null) {
                return true;
            } else {
                return false;
            }
        }
        void push(TreeNode element){
            if (topNode == null) {
                topNode = new Node();
                topNode.element = element;
            }else{
                nextNode = topNode;
                topNode = new Node();
                topNode.element = element;
                topNode.next = nextNode;
            }
        }
        TreeNode pop(){
            Node head = topNode;
            if (nextNode == null) {
                topNode = null;
            }
            else if (nextNode.next == null) {
                topNode = topNode.next;
                nextNode = null;
            }
            else{
                topNode = topNode.next;
                nextNode = topNode.next;
            }
            return head.element;
        }
    }
}
