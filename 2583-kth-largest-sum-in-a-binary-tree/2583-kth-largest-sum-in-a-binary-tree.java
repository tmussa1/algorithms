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
    
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            long sum = 0;
            
            for(int i = 0; i < size; i++){
                
                TreeNode currNode = queue.poll();
                
                sum += currNode.val;
                
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            
            if(pQueue.size() < k){
                pQueue.offer(sum);
            } else {
                if(pQueue.peek() < sum){
                    pQueue.poll();
                    pQueue.offer(sum);
                }
            }
        }
        
        return pQueue.size() == k ? pQueue.peek() : -1;
    }
    
}