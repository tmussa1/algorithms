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
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, "", result);
        return result;
    }
    
    private void binaryTreePaths(TreeNode root, String builder, List<String> result){
        
        if(root !=  null){
            
            builder += root.val + "";
            
            if(root.left == null && root.right == null){             
                result.add(builder);
            } else {
                builder += "->";
                binaryTreePaths(root.left, builder, result);
                binaryTreePaths(root.right, builder, result);
            }
        }
    }
}