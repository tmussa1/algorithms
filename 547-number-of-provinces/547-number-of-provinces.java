class Solution {
    
    private Node findNode(Node node){
        
        if(node != node.parent){
            node.parent = findNode(node.parent);
        }
        
        return node.parent;
    }
    
    private int link(Node node1, Node node2){
        
        Node node1Parent = findNode(node1), node2Parent = findNode(node2);
        
        if(node1Parent == node2Parent) return 0;
        
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
    
    private List<Node> makeSet(int n){
        
        List<Node> nodes = new ArrayList<>();
            
        for(int i = 1; i <= n; i++){
            Node node = new Node();
            node.value = i;
            node.parent = node;
            node.rank = 1;
            nodes.add(node);
        }
        
        return nodes;
    }
    
    public int findCircleNum(int[][] isConnected) {
        
        List<Node> nodes = makeSet(isConnected.length);
        
        int provinces = isConnected.length;
        
        for(int row = 0; row < isConnected.length; row++){
            for(int col = 0; col < isConnected[0].length; col++){
                if(isConnected[row][col] == 1 && row != col){
                    Node node1 = nodes.get(row), node2 = nodes.get(col);
                    provinces -= link(node1, node2);
                }
            }
        }
        
        return provinces;
    }
    
    class Node {
        int value;
        int rank;
        Node parent;
    }
}