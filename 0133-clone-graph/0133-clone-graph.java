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
        return clone(new HashMap<>(), node);
    }
    
    private Node clone(Map<Integer, Node> cloneMap, Node node){
        
        if(node == null) return null;
        
        if(cloneMap.containsKey(node.val)){
            return cloneMap.get(node.val);
        }
        
        Node newNode = new Node(node.val);
        
        cloneMap.put(node.val, newNode);
        
        for(Node neighbor: node.neighbors){
            newNode.neighbors.add(clone(cloneMap, neighbor));
        }
        
        return newNode;
    }
}