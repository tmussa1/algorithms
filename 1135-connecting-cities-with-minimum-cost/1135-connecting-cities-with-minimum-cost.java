class Solution {
    
    class Node {
        int value, rank;
        Node parent;
    }
    
    private Node find(Node node){
        
        if(node != node.parent){
            node.parent = find(node.parent);
        }
        
        return node.parent;
    }
    
    private void link(Node node1, Node node2){
        
        Node node1Parent = find(node1), node2Parent = find(node2);
        
        if(node1Parent == node2Parent){
            return;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1Parent;
        } else if(node1Parent.rank < node2Parent.rank){
            node1Parent.parent = node2Parent;
        } else {
            node2Parent.parent = node1Parent;
            node1Parent.rank += 1;
        }
    }
    
    public int minimumCost(int n, int[][] connections) {
        
        if(connections.length < n - 1) return -1;
        
        Node [] nodes = new Node[n];
        
        for(int i = 0; i < n; i++){
            Node node = new Node();
            node.value = i + 1;
            node.rank = 0;
            node.parent = node; 
            nodes[i] = node;
        }
        
        int connected = 0, index = 0, cost = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        for (int[] connection : connections) {
            pq.offer(connection);
        }
        
        while(connected < n && !pq.isEmpty()){
            
            int[] connection = pq.poll();
            
            Node node1 = nodes[connection[0] - 1], node2 = nodes[connection[1] - 1];
            
            if(find(node1) == find(node2)){
                continue;
            }
            
            link(node1, node2);
            int costForNodes = connection[2];
            cost += costForNodes;
            connected++;
            index++;
        }
        
        return cost;
    }
}