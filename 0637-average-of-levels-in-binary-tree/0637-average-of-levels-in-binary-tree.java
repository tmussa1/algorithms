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
    
    public List<Double> averageOfLevels(TreeNode root) {
        
        if(root == null){
            return new ArrayList<Double>();
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        List<Double> averages = new ArrayList<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            long count = 0, sum = 0;
            
            for(int i = 0; i < size; i++){
                
                TreeNode curr = queue.poll();
                
                sum += curr.val;
                count += 1;
                
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            
            averages.add((sum * 1.0) / (count * 1.0));
        }
        
        return averages;
    }
}