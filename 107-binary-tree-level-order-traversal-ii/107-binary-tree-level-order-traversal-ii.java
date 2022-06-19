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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            List<Integer> lst = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeNode node = queue.poll();
                lst.add(node.val);
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            
            stack.push(lst);
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        
        return result;
    }
}