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
    public String tree2str(TreeNode root) {
        return tree2strHelper(root);
    }
    
    private String tree2strHelper(TreeNode root) {
        
        if(root == null){
            return "";
        }
        
        if(root.right == null && root.left == null){
            return root.val + "";
        }
        
        if(root.right == null){
            return root.val + "(" + tree2strHelper(root.left) + ")";
        }
        
        return root.val + "(" + tree2strHelper(root.left) + ")" + "(" + tree2strHelper(root.right) + ")";
    }
}