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
    
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        dfs(root, null, 0);
        
        int max = Collections.max(levelMap.keySet());
        
        List<TreeNode> nodes = levelMap.get(max);
        
        if(nodes.size() == 1) return nodes.get(0);
        
        Set<Integer> nodeSet = new HashSet<>();
        
        for(TreeNode node: nodes){
            nodeSet.add(node.val);
        }
        
        
        while(nodeSet.size() > 1){
            
            Set<Integer> nodesCopy = new HashSet<>();
            
            for(Integer key: nodeSet){
                 TreeNode node = parentMap.get(key);
                 nodesCopy.add(node.val);
            }
            
            nodeSet = nodesCopy;
        }
        
        return nodeMap.get(new ArrayList<>(nodeSet).get(0));
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level){
        
        if(root == null){
            return;
        }
        
        List<TreeNode> lst = levelMap.getOrDefault(level, new ArrayList<>());
        lst.add(root);
        
        parentMap.put(root.val, parent);
        nodeMap.put(root.val, root);
        levelMap.put(level, lst);
        
        dfs(root.left, root, level + 1);
        dfs(root.right, root, level + 1);
    }
}