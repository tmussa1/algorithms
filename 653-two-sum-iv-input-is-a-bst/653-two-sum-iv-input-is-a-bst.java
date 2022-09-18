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
    
    TreeNode rootNode = null;
    
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        
        rootNode = root;
        
        return findTargetHelper(root, k);
    }
    
     public boolean findTargetHelper(TreeNode node, int k) {
        
        if(node == null) return false;
            
        if(findNode(this.rootNode, k - node.val, node)){
            return true;
        }
        
        return findTargetHelper(node.left, k) || findTargetHelper(node.right, k);
    }
    
    public boolean findNode(TreeNode node, int target, TreeNode curr){
        
        if(node == null) return false;
        
        if(node.val == target && node != curr) return true;
        
        return findNode(node.left, target, curr) || findNode(node.right, target, curr);
    }
}