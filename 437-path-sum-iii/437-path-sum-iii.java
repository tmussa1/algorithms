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
    
    public int pathSum(TreeNode root, int targetSum) {
        
        int [] result = new int[1];
        
        if(root == null) return 0;
        
        traverse(result, root, targetSum);
        
        return result[0];
    }
    
    private void traverse(int [] result, TreeNode root, int targetSum){
        
        if(root == null) return;
        
        dfs(result, root, targetSum);
        traverse(result, root.left, targetSum);
        traverse(result, root.right, targetSum);
    }
    
    private void dfs(int [] result, TreeNode root, int targetSum){
        
        if(root == null) return;
        
        if(targetSum == root.val){
            result[0] += 1;
        }
        
        dfs(result, root.left, targetSum - root.val);
        dfs(result, root.right, targetSum - root.val);
    }
}