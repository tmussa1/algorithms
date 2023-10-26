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


    public int getMinimumDifference(TreeNode root) {
        
        List<Integer> lst = new ArrayList<>();
        
        getMinimumDiff(root, lst);
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int index = 1; index < lst.size(); index++){
            minDiff = Math.min(minDiff, lst.get(index) - lst.get(index - 1));
        }
        
        return minDiff;
    }

    private void getMinimumDiff(TreeNode root, List<Integer> lst) {
        
        if(root == null) return;

        getMinimumDiff(root.left, lst);
      
        lst.add(root.val);
        
        getMinimumDiff(root.right, lst);
    }
}