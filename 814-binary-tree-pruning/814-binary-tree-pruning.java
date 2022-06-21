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
    public TreeNode pruneTree(TreeNode root) {
        
        if(!containsOne(root)) {
            return null;
        }
        
        pruneTree(root, null);
        
        return root;
    }
    
    public void pruneTree(TreeNode root, TreeNode parent) {
        
        if(root == null){
            return;
        }
        
        if(!containsOne(root)){
            if(parent.left != null && parent.left == root){
                parent.left = null;
            } else if(parent.right != null && parent.right == root){
                parent.right = null;
            }
        }
        
        pruneTree(root.left, root);
        pruneTree(root.right, root);
    }
    
    boolean containsOne(TreeNode root){
        
        if(root == null){
            return false;
        }
        
        if(root.val == 1){
            return true;
        }
        
        return containsOne(root.left) || containsOne(root.right);
    }
}