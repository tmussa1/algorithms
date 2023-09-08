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
    
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        removeLeafNodes(root, null, target);
        
        if(root.val == target && root.left == null && root.right == null) return null;
        
        return root;
    }
    
    private void removeLeafNodes(TreeNode root, TreeNode parent, int target) {
        
        if(root == null) return;
        
        if(root.val == target && root.left == null && root.right == null){
            if(parent != null && parent.left == root){
                parent.left = null;
            } else if(parent != null && parent.right == root){
                parent.right = null;
            }
        }
        
        removeLeafNodes(root.left, root, target);
        removeLeafNodes(root.right, root, target);
        
        if(root.val == target && root.left == null && root.right == null){
            if(parent != null && parent.left == root){
                parent.left = null;
            } else if(parent != null && parent.right == root){
                parent.right = null;
            }
        }
    }
}