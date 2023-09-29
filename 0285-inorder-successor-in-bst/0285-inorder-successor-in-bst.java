/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        List<TreeNode> nodes = new ArrayList<>();
        inorderSuccessor(root, nodes);

        for(TreeNode node: nodes){
            if(node.val > p.val){
                return node;
            }
        }

        return null;
    }

    private void inorderSuccessor(TreeNode root, List<TreeNode> nodes){
        if(root == null) return;
        inorderSuccessor(root.left, nodes);
        nodes.add(root);
        inorderSuccessor(root.right, nodes);
    }
}