class Solution {
    public boolean isBipartite(int[][] graph) {
        
        Set<Node> visited = new HashSet<>();
        Map<Node, List<Node>> adjList = constructAdjList(graph);
        
        for(Node nd: adjList.keySet()){
            
            System.out.print(nd.val + " | ");
            
            for(Node nd1: adjList.get(nd)){
               System.out.print(nd1.val + " "); 
            }
            
            System.out.println();
        }
        
        for(Node node: adjList.keySet()){
            
            if(visited.contains(node)){
                continue;
            }
            
            if(!bfs(graph, visited, adjList, node)) {
                return false;
            }
            
            visited.add(node);
        }
        
        return true;
    }
    
    boolean bfs(int[][] graph, Set<Node> visited, Map<Node, List<Node>> adjList, Node node){
        
        node.color = 1;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            
            Node curr = queue.poll();
            
            visited.add(curr);
            
            if(adjList.containsKey(curr)){
                for(Node adjNode: adjList.get(curr)) {
                    if(adjNode.color == curr.color){
                        return false;
                    }
                    
                    if(adjNode.color == -1){
                        adjNode.color = curr.color == 1 ? 2 : 1;
                        queue.offer(adjNode);
                    }
                }
            }
        }
        
        return true;
    }
    
    Node findNode(Map<Node, List<Node>> adjList) {
        
        Node result = null;
        
        int min = Integer.MAX_VALUE;
        
        for(Node node: adjList.keySet()){
            if(node.val < min){
                result = node;
            }
        }
        
        return result;
    }
    
    
    Map<Node, List<Node>> constructAdjList(int[][] graph){
        
        Map<Node, List<Node>> adjList = new HashMap<>();
        Map<Integer, Node> nodes = new HashMap<>();
        
        for(int i = 0; i < graph.length; i++){
            
            Node node = nodes.getOrDefault(i, new Node(i));
            
            List<Node> lst = adjList.getOrDefault(node, new ArrayList<>());
            
            for(int j = 0; j < graph[i].length; j++){
                Node adjNode = nodes.getOrDefault(graph[i][j], new Node(graph[i][j]));
                lst.add(adjNode);
                nodes.put(adjNode.val, adjNode);
            }
            
            nodes.put(node.val, node);
            adjList.put(node, lst);
        }
        return adjList;
    }
        
    class Node {
        
        int val;
        int color;
        
        Node(int val){
            this.val = val;
            this.color = -1;
        }
    }
}