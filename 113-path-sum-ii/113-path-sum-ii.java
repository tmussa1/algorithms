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
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
            
        dfs(result, new ArrayList<>(), root, targetSum);
        
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> currList, TreeNode root, int targetSum){
        
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null && targetSum == root.val){
            currList.add(root.val);
            result.add(new ArrayList<>(currList));
            currList.remove(currList.size() - 1);
            return;
        }
        
        currList.add(root.val);
        
        dfs(result, currList, root.left, targetSum - root.val);
        dfs(result, currList, root.right, targetSum - root.val);
        
        targetSum += root.val;
        currList.remove(currList.size() - 1);
    }
}