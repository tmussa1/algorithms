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
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        
        return trimBST2(root, low, high);
    }
    
    private TreeNode trimBST2(TreeNode root, int low, int high) {
        
        if(root == null) return null;
        
        if(root.val < low) {
            return trimBST2(root.right, low, high);
        } else if(root.val > high){
            return trimBST2(root.left, low, high);
        }
        
        root.left = trimBST2(root.left, low, high);
        root.right = trimBST2(root.right, low, high);
        
        return root;
    }
}