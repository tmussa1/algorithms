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
        return convertBinary(0, nums.length, nums);
    }
    
    private TreeNode convertBinary(int start, int end, int[] nums){
        
        if(start >= end){
            return null;
        }
        
        int mid = start + ((end - start) / 2);
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = convertBinary(start, mid, nums);
        root.right = convertBinary(mid + 1, end, nums);
        
        return root;
    }
}

