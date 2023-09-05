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
    
    public TreeNode bstToGst(TreeNode root) {
        
        List<Integer> lst = new ArrayList<>();
        
        inorderTraversal(root, lst);
        
        Map<Integer, Integer> suffixSum = new HashMap<>();
        
        int runningSum = 0;
        
        for(int i = lst.size() - 1; i >= 0; i--){
            runningSum += lst.get(i);
            suffixSum.put(lst.get(i), runningSum);
        }
        
        preorderTraversal(root, suffixSum);
        
        return root;
    }
    
    private void preorderTraversal(TreeNode root,  Map<Integer, Integer> suffixSum){
        
        if(root == null) return;
        
        root.val = suffixSum.get(root.val);
        
        preorderTraversal(root.left, suffixSum);
        preorderTraversal(root.right, suffixSum);
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> lst){
        
        if(root == null) return;
        
        inorderTraversal(root.left, lst);
        
        lst.add(root.val);
        
        inorderTraversal(root.right, lst);
    }
}