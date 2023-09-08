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
    
    int result = 0;
    
    public int equalToDescendants(TreeNode root) {
       findEqual(root);
       return result;
    }
    
    private int findEqual(TreeNode root) {
        
        if(root == null) return 0;
        
        int left = findEqual(root.left);
        int right = findEqual(root.right);
        
        int sum = 0;
        
        sum += left + right;
        
        if(sum == root.val){
            result++;
        }
        
        sum += root.val;
        
        return sum;
    }
}