/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    
    public Node lowestCommonAncestor(Node p, Node q) {
        
        Map<Integer, Node> levelMap = new HashMap<>();
        Map<Integer, Node> level2Map = new HashMap<>();
        
        findLevel(levelMap, p, 0);
        findLevel(level2Map, q, 0);
        
        int maxLevel = Collections.max(new ArrayList<>(levelMap.keySet()));
        int max2Level = Collections.max(new ArrayList<>(level2Map.keySet()));
        
        while(max2Level > maxLevel){
            q = q.parent;
            max2Level--;
        }
        
        while(maxLevel > max2Level){
            p = p.parent;
            maxLevel--;
        }
        
        while(p != q){
            p = p.parent;
            q = q.parent;
        }
        
        return p;
    }
    
    private void findLevel(Map<Integer, Node> levelMap, Node node, int level){
        
        if(node == null){
            return;
        }
        
        levelMap.put(level, node);
        
        findLevel(levelMap, node.parent, level + 1);
    }
}