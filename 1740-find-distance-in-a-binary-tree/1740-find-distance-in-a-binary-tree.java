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
    public int findDistance(TreeNode root, int p, int q) {
        
        TreeNode lca = findLCA(root, p, q);
        
        int pDistance = calculateDistance(lca, p, 0);
        int qDistance = calculateDistance(lca, q, 0);

        return pDistance + qDistance;
    }
    
    private int calculateDistance(TreeNode root, int p, int distance){
        
        if(root == null) return -1;
        
        if(root.val == p) {
            return distance;
        }
        
        int left = calculateDistance(root.left, p, distance + 1);
        int right = calculateDistance(root.right, p, distance + 1);
        
        return left != -1 ? left : right;
    }
    
    private TreeNode findLCA(TreeNode root, int p, int q){
        
        if(root == null) return null;
        
        if(root.val == p || root.val == q) return root;
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        }
        
        return right != null ? right : left;
    }
}