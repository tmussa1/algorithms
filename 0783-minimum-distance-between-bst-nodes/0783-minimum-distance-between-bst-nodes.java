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
    
    public int minDiffInBST(TreeNode root) {
        return findDiff(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private int findDiff(TreeNode root, int min, int max){
        
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        
        int res = Integer.MAX_VALUE;
        
        if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
            res = Math.abs(min - max);
            res = Math.min(res, Math.abs(root.val - min));
            res = Math.min(res, Math.abs(root.val - max));
        }
        
        if(min != Integer.MAX_VALUE) {
            res = Math.min(res, Math.abs(root.val - min));
        }
        
        if(max != Integer.MIN_VALUE) {
            res = Math.min(res, Math.abs(root.val - max));
        }
        
        int result = Math.min(res, 
                        Math.min(findDiff(root.left, min, root.val),
                                 findDiff(root.right, root.val, max)));
        
        return result;
    }
}