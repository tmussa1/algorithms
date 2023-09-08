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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Set<TreeNode> lst = findDeepestLeaves(root);
        
        Set<Integer> values = new HashSet<>();
        
        for(TreeNode node: lst) {
            values.add(node.val);
        }
        
        return findLca(root, values);
    }
    
    private TreeNode findLca(TreeNode root, Set<Integer> values){
        
        if(root == null) return root;
        
        if(values.contains(root.val)){
            return root;
        }
        
        TreeNode left = findLca(root.left, values);
        TreeNode right = findLca(root.right, values);
        
        if(left != null && right != null) {
            return root;
        }
        
        return right != null ? right : left;
    }
    
    private Set<TreeNode> findDeepestLeaves(TreeNode root){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        Set<TreeNode> set = null;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            set = new HashSet<>(queue);
            
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
        
        return set;
    }
}