class Solution {
    
    class Node {
        int val, rank;
        Node parent;
    }
    
    private Node findParent(Node node) {
        
        if(node.parent != node){
            node.parent = findParent(node.parent);
        }
        
        return node.parent;
    }
    
    private int link(Node node1, Node node2){
        
        node1 = findParent(node1);
        node2 = findParent(node2);
        
        if(node1 == node2) {
            return 0;
        }
        
        if(node1.rank > node2.rank){
            node2.parent = node1;
        } else if(node2.rank > node1.rank){
            node1.parent = node2;
        } else {
            node2.parent = node1;
            node1.rank += 1;
        }
        
        return 1;
    }
        
        
    public long countPairs(int n, int[][] edges) {
        
        Node [] nodes = new Node[n];
        
        long connectedComponents = n;
        
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
            nodes[i].val = i;
            nodes[i].parent = nodes[i];
        }
        
        for(int [] edge: edges){
            Node node1 = nodes[edge[0]], node2 = nodes[edge[1]];
            connectedComponents -= link(node1, node2);
        }
        
        long [] connectedCount = new long[n];
        
        for(int i = 0; i < n; i++){
            connectedCount[findParent(nodes[i]).val] += 1;
        }   
        
        long sum = Arrays.stream(connectedCount).sum();
        
        long result = 0;
        
        for(int i = 0; i < n; i++){
            if(connectedCount[i] > 0){
                result += (n - connectedCount[i]) * connectedCount[i];
            }
        }
        
        return result / 2;
    }
}