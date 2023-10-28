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
    
    Map<Integer, Integer> indegreeMap = new HashMap<>();
    
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    
    TreeNode firstNode;
        
    public TreeNode correctBinaryTree(TreeNode root) {
        
        populateIndegree(root);
        
        // System.out.println(indegreeMap);
        
//         for(Integer key: indegreeMap.keySet()){
            
//             if(indegreeMap.get(key) > 1){
                
                TreeNode node = parentMap.get(firstNode.val);
                
                TreeNode parent = parentMap.get(node.val);
                
                // System.out.println("parent " + parent.val + " key " + firstNode.val + " node " + node.val
                //                   + " right " + node.right.val);
                
                if(parent.left == node){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            //     return root;
            // }
        // }
        
        return root;
    }
    
    private void populateIndegree(TreeNode root){
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            TreeNode curr = queue.poll();
            
            indegreeMap.put(curr.val, indegreeMap.getOrDefault(curr.val, 0) + 1);
            
            if(firstNode == null && indegreeMap.get(curr.val) > 1){
                firstNode = curr;
            }
            
            if(curr.left != null){
                queue.offer(curr.left);
                int val = curr.left.val;
                parentMap.put(val, curr);
            }
            
            if(curr.right != null){
                queue.offer(curr.right);
                int val = curr.right.val;
                parentMap.put(val, curr);
            }
        }
    }
}