/*
 * 94. Binary Tree Inorder Traversal
Easy
Topics
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode T = new TreeNode(1);
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        T.left = new TreeNode(2);
        T.right = new TreeNode(3);
        T.left.left = new TreeNode(4);
        T.left.right = new TreeNode(5);
        T.right.left = new TreeNode(6);
        T.right.right = new TreeNode(7);

        System.out.println(b.inorderTraversal(T));
        
    }
    
// }
// class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> L = new ArrayList<>();
        if (root != null) {
            
            if (root.left != null) {
                L.addAll(inorderTraversal(root.left));
            }
            
            L.add(root.val);

            if (root.right != null) {
                L.addAll(inorderTraversal(root.right));
            }
        }

        return L;
    }
}


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
