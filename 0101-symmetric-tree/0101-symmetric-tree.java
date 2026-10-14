/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they match
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one of them is null, or values don't match, it's not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        
        // Recursively check:
        // 1. Left child of t1 with right child of t2
        // 2. Right child of t1 with left child of t2
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}