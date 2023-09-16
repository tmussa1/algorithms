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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> result = new ArrayList<>();
        
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        
        inorder(root1, lst1);
        inorder(root2, lst2);
        
        int index1 = 0, index2 = 0;
        
        while(index1 < lst1.size() && index2 < lst2.size()){
            if(lst1.get(index1) < lst2.get(index2)){
                result.add(lst1.get(index1));
                index1++;
            } else {
                result.add(lst2.get(index2));
                index2++;
            }
        }
        
        while(index1 < lst1.size()) {
            result.add(lst1.get(index1));
            index1++;
        }
        
        while(index2 < lst2.size()) {
            result.add(lst2.get(index2));
            index2++;
        }
        
        return result;
    }
    
    private void inorder(TreeNode root, List<Integer> lst){
        
        if(root == null) return;
        
        inorder(root.left, lst);
        
        if(root != null){
            lst.add(root.val);
        }
        
        inorder(root.right, lst);
    }
}