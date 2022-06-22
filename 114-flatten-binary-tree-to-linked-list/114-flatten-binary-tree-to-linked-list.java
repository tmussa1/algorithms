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
    
    public void flatten(TreeNode root) {
        
        flattenHelper(root);
    }
    
    TreeNode flattenHelper(TreeNode root){
        
        if(root == null){
            return null;
        }
        
        if(root.left == null && root.right == null){
            return root;
        }
        
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        
        if(left != null){
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        return right != null ? right : left;
    }
}