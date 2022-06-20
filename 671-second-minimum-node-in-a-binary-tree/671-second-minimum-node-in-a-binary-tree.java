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
    
    public int findSecondMinimumValue(TreeNode root) {
        
        if(root == null || (root.right == null && root.left == null)) return -1;
        
        if(root.right == null) return root.left.val;
        
        if(root.left == null) return root.right.val;
        
        int left = root.left.val;
        int right = root.right.val;
        
        int max = Math.max(root.left.val, right);
        
        if(max == root.val){
            max = Integer.MAX_VALUE;
        }
        
        int result = findSecondMinimumValue(root, root.val, max);
        
        return (result == Integer.MAX_VALUE && right != Integer.MAX_VALUE && left != Integer.MAX_VALUE) 
            || (right == Integer.MAX_VALUE && left == Integer.MAX_VALUE)? -1 : result;
    }
    
    private int findSecondMinimumValue(TreeNode root, int min, int max){
        
        if(root == null){
            return Integer.MAX_VALUE;
        }
        
        if(root.val > min && root.val <= max){
            return root.val;
        }
        
        return Math.min(findSecondMinimumValue(root.left, min, max), 
                        findSecondMinimumValue(root.right, min, max));
    }
}