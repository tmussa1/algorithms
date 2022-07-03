class Solution {
    
    int link(Node node1, Node node2){
        
        Node node1Parent = find(node1);
        Node node2Parent = find(node2);
        
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
    
    Node find(Node node){
        
        if(node != node.parent){
            node.parent = find(node.parent);
        }
        
        return node.parent;
    }
    
    Node [] makeSet(int[][] edges){
        
        Node [] nodes = new Node[edges.length];
        
        for(int i = 0; i < edges.length; i++){
            nodes[i] = new Node();
            nodes[i].rank = 1;
            nodes[i].x = edges[i][0];
            nodes[i].y = edges[i][1];
            nodes[i].parent = nodes[i];
        }
        
        return nodes;
    }
    
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int [] result = new int[2];
        
        Node [] nodes = makeSet(edges);
        
        for(int i = 0; i < nodes.length; i++){
            
            Node node1 = nodes[nodes[i].x - 1];
            Node node2 = nodes[nodes[i].y - 1];
            
            if(link(node1, node2) == 0){
                result[0] = edges[i][0];
                result[1] = edges[i][1];
            } 
        }
        
        return result;
    }
    
    
    class Node {
        int rank;
        int x, y;
        Node parent;
    }
}