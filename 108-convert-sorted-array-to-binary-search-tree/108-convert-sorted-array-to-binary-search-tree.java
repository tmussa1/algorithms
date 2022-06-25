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
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length == 1) return new TreeNode(nums[0]);
        
        return sortedArrayToBST(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        
        if(start >= end){
            return null;
        }                   
        
        int middle = start + ((end - start) / 2);
        
        TreeNode node = new TreeNode(nums[middle]);
        
        node.left = sortedArrayToBST(nums, start, middle);
        node.right = sortedArrayToBST(nums, middle + 1, end);
        
        return node;
    }
}