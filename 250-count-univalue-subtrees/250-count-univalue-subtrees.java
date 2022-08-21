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
    
    public int countUnivalSubtrees(TreeNode root) {
        
        int [] result = new int[1];
        
        countUnivalSubtrees(root, result);
        
        return result[0];
    }
    
    private void countUnivalSubtrees(TreeNode root, int [] result){
        
        if(root == null){
            return;
        }
        
        if(areEqual(root, root.val)){
            result[0] += 1;
        }
        
        countUnivalSubtrees(root.left, result);
        countUnivalSubtrees(root.right, result);
    }
    
    boolean areEqual(TreeNode root, int value) {
        
        if(root == null) return true;
        
        if(root.val != value) {
            return false;
        }
        
        return areEqual(root.left, value) && areEqual(root.right, value);
    }
}