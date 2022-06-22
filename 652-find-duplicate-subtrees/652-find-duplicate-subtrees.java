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
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        Map<String, TreeNode> result = new HashMap<>();
        
        checkDuplicates(root, new HashSet<>(), result);
        
        return new ArrayList<>(result.values());
    }
    
    private void checkDuplicates(TreeNode root, Set<String> visited, Map<String, TreeNode> result){
        
        if(root == null){
            return;
        }
        
        String serialized = serialize(root);
        
        if(visited.contains(serialized)){
            result.put(serialized, root);
        }
        
        visited.add(serialized);
        
        checkDuplicates(root.left, visited, result);
        checkDuplicates(root.right, visited, result);
    }
    
    private String serialize(TreeNode root){
        
        if(root == null){
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        String left = "X", right = "X";
        
        if(root.left != null){
            left = serialize(root.left);
        }
        
        if(root.right != null){
            right = serialize(root.right);
        }
        
        builder.append(root.val);
        builder.append(",");
        builder.append(left);
        builder.append(",");
        builder.append(right);
        
        return builder.toString();
    }
}