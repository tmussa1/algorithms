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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new LinkedList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int leftToRight = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            LinkedList<Integer> currList = new LinkedList<>();
                
            for(int i = 0; i < size; i++){
                
                TreeNode node = queue.poll();
                    
                if(leftToRight % 2 == 0){
                    currList.addLast(node.val);
                } else {
                    currList.addFirst(node.val);
                }
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            
            result.add(currList);
            
            leftToRight++;
        }
        
        return result;
    }
}