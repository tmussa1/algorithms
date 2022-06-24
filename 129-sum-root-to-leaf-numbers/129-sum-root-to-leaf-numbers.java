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
    public int sumNumbers(TreeNode root) {
        dfs(root);
        int [] sum = new int[1];
        sumUpLeaves(root, sum);
        return sum[0];
    }
    
    private void sumUpLeaves(TreeNode root, int [] sum){
        
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            sum[0] += root.val;
        }
        
        sumUpLeaves(root.left, sum);
        sumUpLeaves(root.right, sum);
    }
    
    private void dfs(TreeNode root){
        
        if(root == null){
            return;
        }
    
        if(root.left != null){
            root.left.val += (root.val * Math.pow(10, 1));
            dfs(root.left);
        }
        
        if(root.right != null){
            root.right.val += (root.val * Math.pow(10, 1));
            dfs(root.right);
        }
        
    }
}