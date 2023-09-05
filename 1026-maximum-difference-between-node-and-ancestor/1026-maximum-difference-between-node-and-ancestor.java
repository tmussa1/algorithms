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
    
    public int maxAncestorDiff(TreeNode root) {
        return findDiff(root, root.val, root.val);
    }
    
    private int findDiff(TreeNode root, int lower, int higher){
        
        if(root == null) return 0;
        
        lower = Math.min(root.val, Math.min(lower, higher));
        
        higher = Math.max(root.val, Math.max(lower, higher));
        
        int diff = Math.abs(lower - higher);
        
        return Math.max(Math.max(findDiff(root.left, lower, higher), findDiff(root.right, lower, higher)), diff);
    }
}