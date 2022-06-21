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
    
    public int minDepth(TreeNode root) {
        
        int [] minLevel = new int[1];
        minLevel[0] = Integer.MAX_VALUE;
        
        minDepth(root, 1, minLevel);
        
        return minLevel[0] == Integer.MAX_VALUE ? 0 : minLevel[0];
    }
    
    private void minDepth(TreeNode root, int level, int[] minLevel){
        
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null){
            
            if(level < minLevel[0]){
                minLevel[0] = level;
            }
        }
        
        minDepth(root.left, level + 1, minLevel);
        minDepth(root.right, level + 1, minLevel);
    }
}