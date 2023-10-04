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
    
    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        index = postorder.length - 1;
        
        Map<Integer, Integer> inorderMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        
        return buildTree(postorder, inorderMap, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap, int left, int right){
        
        if(left > right){
            return null;
        }
        
        int val = postorder[index];
        
        TreeNode root = new TreeNode(val);
        
        index--;
        
        root.right = buildTree(postorder, inorderMap, inorderMap.get(val) + 1, right);
        
        root.left = buildTree(postorder, inorderMap, left, inorderMap.get(val) - 1);
        
        return root;
    }
}