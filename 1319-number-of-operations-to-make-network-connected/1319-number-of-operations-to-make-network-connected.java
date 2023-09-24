class Solution {
    
    class Node {
        int val, rank;
        Node parent;
    }
    
    private Node findParent(Node node){
        
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
        
        if(node1.rank > node2.rank){
            node2.parent = node1;
        } else if(node1.rank < node1.rank){
            node1.parent = node2;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }
        
        return 1;
    }
    public int makeConnected(int n, int[][] connections) {
        
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            Node node = new Node();
            node.val = i;
            node.parent = node;
            node.rank = 0;
            nodes.add(node);
        }
        
        int cycles = 0, connecting = 0;
        
        for(int [] connection: connections){
            
           Node node1 = findParent(nodes.get(connection[0]));
           Node node2 = findParent(nodes.get(connection[1]));
            
           if(node1 == node2){
               cycles++;
           } else {
               link(node1, node2);
           }
        }
        
        for(int i = 1; i < n; i++){
           
           Node node1 = findParent(nodes.get(i - 1));
           Node node2 = findParent(nodes.get(i));
            
           if(node1 == node2){
              continue;
           } else {
              connecting += link(node1, node2);
           }
        }
        
        return connecting <= cycles ? connecting : -1;
    }
}