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
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
      
        while(!(root.left == null && root.right == null)){
            findLeaves(root, null, new ArrayList<>(), result);
        }
        
        result.add(Arrays.asList(root.val));
        
        return result;
    }
    
    private void findLeaves(TreeNode root, TreeNode parent, List<Integer> currList, List<List<Integer>> result){
        
        if(root == null){
            result.add(currList);
            return;
        }
        
        if(root.left == null && root.right == null){
            
            currList.add(root.val);
            
            if(parent.left != null && parent.left.val == root.val){
                parent.left = null;
            }
           
            if(parent.right != null && parent.right.val == root.val){
                parent.right = null;
            }
        }
        
        findLeaves(root.left, root, currList, result);
        findLeaves(root.right, root, currList, result);
        
        result.remove(result.size() - 1);
    }
}