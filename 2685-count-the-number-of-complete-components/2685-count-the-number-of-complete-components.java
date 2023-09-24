class Solution {
    
    class Node {
        int val, rank;
        Node parent;
    }
    
    Node findParent(Node node){
        if(node.parent != node){
            node.parent = findParent(node.parent);
        }
        return node.parent;
    }
    
    private int link(Node node1, Node node2){
        
        node1 = findParent(node1);
        node2 = findParent(node2);
        
        if(node1 == node2){
            return 0;
        }
        
        if(node1.rank < node2.rank){
            node1.parent = node2;
        } else if(node1.rank > node2.rank){
            node2.parent = node1;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }
        
        return 1;
    }
    
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            Node node = new Node();
            node.val = i;
            node.rank = 0;
            node.parent = node;
            nodes.add(node);
        }
        
        int [] connectedCount = new int[n];
        int [] size = new int[n];
        
        for(int [] edge: edges){
            int edge1 = edge[0], edge2 = edge[1];
            Node node1 = nodes.get(edge1), node2 = nodes.get(edge2);
            link(node1, node2);
        }
        
        for(int i = 0; i < n; i++){
            size[findParent(nodes.get(i)).val] += 1;
        }
        
        for(int [] edge: edges){
            int edge1 = edge[0];
            connectedCount[findParent(nodes.get(edge1)).val] += 1;
        }
        
        int completedConnected = 0;
        
            
        for(int i = 0; i < n; i++){
            
            int s = size[i];
            
            if(s > 0 && s * (s - 1) / 2 == connectedCount[i]){
                completedConnected++;
            }
        }
        
        return completedConnected;
    }
}