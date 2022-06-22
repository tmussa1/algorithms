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
    
    public int kthSmallest(TreeNode root, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        kthSmallestHelper(root, queue);
        
        int result = 0;
        
        while(!queue.isEmpty() && k > 1){
            queue.poll();
            k--;
        }
        
        result = queue.poll();
        
        return result;
    }
    
    private void kthSmallestHelper(TreeNode root, PriorityQueue<Integer> queue) {
        
        if(root == null){
            return;
        }
        
        kthSmallestHelper(root.left, queue);
        
        kthSmallestHelper(root.right, queue); 
        
        queue.offer(root.val);
    }
}