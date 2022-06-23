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
    public int goodNodes(TreeNode root) {
        
        int [] result = new int[1];
        
        goodNodes(root, root.val, result);
        
        return result[0];
    }
    
    private void goodNodes(TreeNode root, int maxInPath, int [] result) {
        
        if(root == null) return;
        
        if(root.val >= maxInPath){
            result[0] += 1;
            maxInPath = root.val;
        } 
        
        goodNodes(root.left, maxInPath, result);
        goodNodes(root.right, maxInPath, result);
    }
}