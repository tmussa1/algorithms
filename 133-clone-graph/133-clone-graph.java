/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        
        return cloneGraph(node, new HashMap<Node, Node>());
    }
    
    private Node cloneGraph(Node node, Map<Node, Node> visited) {
        
        if(node == null) return node;
        
        Node clone = new Node(node.val);
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        visited.put(node, clone);
        
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor, visited)); 
        }
        
        return clone;
    }
}