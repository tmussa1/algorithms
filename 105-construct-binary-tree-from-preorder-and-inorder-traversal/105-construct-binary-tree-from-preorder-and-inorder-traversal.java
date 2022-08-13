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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        
        for(int i = 0; i < preorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, inorder, 0, preorder.length - 1, inOrderMap);
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, 
                       int left, int right,
                       Map<Integer, Integer> inOrderMap){
        
        if(left > right){
            return null;
        }
        
        if(index == preorder.length){
            return null;
        }
        
        int value = preorder[index++];
        
        TreeNode root = new TreeNode(value);
        root.left = buildTree(preorder, inorder, left, inOrderMap.get(value) - 1, inOrderMap);
        root.right = buildTree(preorder, inorder, inOrderMap.get(value) + 1, right, inOrderMap);
        
        return root;
    }
}