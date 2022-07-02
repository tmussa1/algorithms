class Solution {
    
    int link(Node node1, Node node2){
        
        Node node1Parent = findParent(node1);
        Node node2Parent = findParent(node2);
        
        if(node1Parent == node2Parent){
            return 0;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1Parent;
        } else if(node2Parent.rank > node1Parent.rank){
            node1Parent.parent = node2Parent;
        } else {
            node2Parent.parent = node1Parent;
            node1Parent.rank += 1;
        }
        
        return 1;
    }
    
    Node findParent(Node node){
        
        if(node != node.parent){
            node.parent = findParent(node.parent);
        }
        
        return node.parent;
    }
    
    Node [] makeSet(int n){
        
        Node [] nodes = new Node[n];
        
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
            nodes[i].val = i;
            nodes[i].rank = 1;
            nodes[i].parent = nodes[i];
        }
        
        return nodes;
    }
    
    public int countComponents(int n, int[][] edges) {
        
        Node [] vertices = makeSet(n);
        
        int result = n;
        
        for(int i = 0; i < edges.length; i++){
            
            Node node1 = vertices[edges[i][0]];
            Node node2 = vertices[edges[i][1]];
            result -= link(node1, node2);
        }
        
        return result;
    }
    
    class Node {
        int val;
        int rank;
        Node parent;
    }
}