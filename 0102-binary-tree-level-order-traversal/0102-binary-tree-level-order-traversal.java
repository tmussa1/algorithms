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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            List<Integer> currList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode currNode = queue.poll();
                
                currList.add(currNode.val);
                
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            
            result.add(currList);
        }
        
        return result;
    }
}