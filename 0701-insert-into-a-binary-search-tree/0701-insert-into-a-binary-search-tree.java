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
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode toInsert = new TreeNode(val);
        
        insertIntoBST(root, toInsert, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        return root == null ? toInsert : root;
    }
    
    private void insertIntoBST(TreeNode root, TreeNode toInsert, int lower, int higher) {
        
        if(root == null) return;
        
        if(toInsert.val > lower && toInsert.val < higher){
            
            if(toInsert.val < root.val && root.left == null){
                root.left = toInsert;
                return;
            } else if(toInsert.val > root.val && root.right == null){
                root.right = toInsert;
                return;
            }
        }
        
        insertIntoBST(root.left, toInsert, lower, root.val);
        insertIntoBST(root.right, toInsert, root.val, higher);
    }
}