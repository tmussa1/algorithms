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
        
        if(root == null){
            return 0;
        }
        
        int count = 0;
        if(areEqual(root, root.val)){
           count += 1;
        }
        
        count += countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        
        return count;
    }
    
    boolean areEqual(TreeNode root, int value) {
        
        if(root == null) return true;
        
        if(root.val != value) {
            return false;
        }
        
        return areEqual(root.left, value) && areEqual(root.right, value);
    }
}