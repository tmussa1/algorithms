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
    
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode []> queue = new LinkedList<>();
        queue.offer(new TreeNode [] {root, root});
        
        List<TreeNode> prevParent = new ArrayList<>();
        prevParent.add(root);
        
        int level = 1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            List<TreeNode> currParent = new ArrayList<>();
            
            int nodes = 0;
            
            for(int i = 0; i < size; i++){
                
                TreeNode [] curr = queue.poll();
                currParent.add(curr[0]);
                
                TreeNode parent = prevParent.get(nodes);
                
              //  System.out.println("Curr " + curr[0].val + " parent " + parent.val);
                
                if(parent != curr[1] || (parent.left == null && parent.right == curr[0])){
                    return false;
                }
                
                if(i % 2 == 1){
                   nodes++;
                }
                
                if(curr[0].left != null){
                    queue.offer(new TreeNode [] {curr[0].left, curr[0]});
                }
                
                if(curr[0].right != null){
                    queue.offer(new TreeNode [] {curr[0].right, curr[0]});
                }
            }
            
            if(size < level && !queue.isEmpty()) return false;
            
            level *= 2;
            
            prevParent = currParent;
        }
        
        return true;
    }
}