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
    
    int index = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int lower, int higher) {
        
        if(index == preorder.length) return null;
        
        int nextVal = preorder[index];
        
        if(nextVal < lower || nextVal > higher) return null;
        
        index++;
        
        TreeNode root = new TreeNode(nextVal);
        
        root.left = bstFromPreorder(preorder, lower, nextVal);
        root.right = bstFromPreorder(preorder, nextVal, higher);
        
        return root;
    }
}