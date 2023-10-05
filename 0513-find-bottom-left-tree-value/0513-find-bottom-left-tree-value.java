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
    
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<TreeNode> list = null;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            list = new ArrayList<>();
            list.addAll(queue);
            
            for(int i = 0; i < size; i++){
                
                TreeNode curr = queue.poll();
                
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        
        return list.get(0).val;
    }
}