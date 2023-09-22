/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public Node findRoot(List<Node> tree) {
        
        Map<Integer, Node> nodeMap = new HashMap<>();
        
        Map<Integer, Integer> indegreeMap = buildIndegreeMap(tree, nodeMap);
        
        Node root = null;
        
        for(Integer key: indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0){
                root = nodeMap.get(key);
            }
        }
        
        return root;
    }
    
    private Map<Integer, Integer> buildIndegreeMap(List<Node> tree, 
                                                   Map<Integer, Node> nodeMap){
        
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        
        for(Node node: tree){
            nodeMap.put(node.val, node);
            indegreeMap.put(node.val, indegreeMap.getOrDefault(node.val, 0));
            for(Node child: node.children){
                indegreeMap.put(child.val, indegreeMap.getOrDefault(child.val, 0) + 1);
                nodeMap.put(child.val, child);
            }
        }
        
        return indegreeMap;
    }
}