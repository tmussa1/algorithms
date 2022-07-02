class Solution {
    
    void link(Node node1, Node node2){
        
        Node node1Parent = findParent(node1);
        Node node2Parent = findParent(node2);
        
        if(node1Parent == node2Parent){
            return;
        }
        
        if(node1Parent.rank > node2Parent.rank){
            node2Parent.parent = node1Parent;
        } else if(node2Parent.rank > node1Parent.rank){
            node1Parent.parent = node2Parent;
        } else {
            node2Parent.parent = node1Parent;
            node1Parent.rank += 1;
        }
    }
    
    Node findParent(Node node){
        
        if(node != node.parent){
            node.parent = findParent(node.parent);
        }
        
        return node.parent;
    }
    
    Node [] makeSet(int[][] points){
        
        Node [] nodes = new Node[points.length];
            
        for(int i = 0; i < points.length; i++){
            int [] point1 = points[i];
            nodes[i] = new Node();
            nodes[i].x = point1[0];
            nodes[i].y = point1[1];
            nodes[i].rank = 1;
            nodes[i].parent = nodes[i];
        }
        
        return nodes;
    }
    
     Edge [] makeEdges(Node [] nodes){
        
        List<Edge> edges = new ArrayList<>();
            
        for(int i = 0; i < nodes.length; i++){
            for(int j = 0; j < i; j++){
                int distance = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
                Edge edge = new Edge();
                edge.node1 = nodes[i];
                edge.node2 = nodes[j];
                edge.distance = distance;
                edges.add(edge);
            }
        }
         
        Edge [] result = new Edge[edges.size()];
         
        for(int i = 0; i < edges.size(); i++){
            result[i] = edges.get(i);
        }
        
        return result;
    }
    
    public int minCostConnectPoints(int[][] points) {
        
        Node [] nodes = makeSet(points);
        
        Edge [] edges = makeEdges(nodes);
        
        Arrays.sort(edges, (a, b) -> a.distance - b.distance);
        
        int result = 0, vertices = 0;
        
        for(int i = 0; i < edges.length; i++){
            
            Node node1 = edges[i].node1, node2 = edges[i].node2;
            
            if(findParent(node1) != findParent(node2)){
                link(node1, node2);
                result += edges[i].distance;
                vertices++;
            }
            
            if(vertices > points.length - 1){
                break;
            }
        }
        
        return result;
    }
    
    class Node {
        int rank;
        int x, y;
        Node parent;
    }
    
    class Edge {
        Node node1, node2;
        int distance;
    }
}