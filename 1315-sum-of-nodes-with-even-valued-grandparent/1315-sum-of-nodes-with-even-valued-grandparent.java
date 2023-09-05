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
    
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, null, null);
    }
    
    private int sumEvenGrandparent(TreeNode root, TreeNode parent, TreeNode grandParent) {
        
        if(root == null) return 0;
        
        int sum = 0;
        
        if(grandParent != null && grandParent.val % 2 == 0){
            sum += root.val;
        }
        
        return sum + sumEvenGrandparent(root.left, root, parent)
               + sumEvenGrandparent(root.right, root, parent);
    }
}