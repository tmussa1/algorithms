class Solution {
    
    public int minReorder(int n, int[][] connections) {
        
        Set<Integer> visited = new HashSet<>();
        
        Map<Integer, Set<Integer>> neighborMap = new HashMap<>();
        
        Map<Integer, Set<Integer>> adjList = buildAdjList(n, connections, neighborMap);
        
        return bfs(0, adjList, neighborMap, visited);
    }
    
    private int bfs(int node, Map<Integer, Set<Integer>> adjList,
                    Map<Integer, Set<Integer>> neighborMap,
                    Set<Integer> visited){
        
        int reorders = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                visited.add(curr);
                
                Set<Integer> neighbors = neighborMap.get(curr);
                Set<Integer> path = adjList.get(curr);
                
                for(int neighbor: neighbors){
                    if(!visited.contains(neighbor)){
                       if(!path.contains(neighbor)){
                          reorders++;
                       } 
                       queue.offer(neighbor);
                    }
                }
            }
            
        }
        
        return reorders;
    }
    
    Map<Integer, Set<Integer>> buildAdjList(int n, int[][] connections,
                                             Map<Integer, Set<Integer>> neighborMap){
        
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
            
        for(int i = 0; i < n; i++){
            adjList.put(i, new HashSet<>());
        }
        
        for(int [] connection: connections){
            Set<Integer> lst = adjList.getOrDefault(connection[1], new HashSet<>());
            lst.add(connection[0]);
            adjList.put(connection[1], lst);
            Set<Integer> lst1 = neighborMap.getOrDefault(connection[0], new HashSet<>());
            lst1.add(connection[1]);
            neighborMap.put(connection[0], lst1);
            Set<Integer> lst2 = neighborMap.getOrDefault(connection[1], new HashSet<>());
            lst2.add(connection[0]);
            neighborMap.put(connection[1], lst2);
        }
        
        return adjList;
    }
}