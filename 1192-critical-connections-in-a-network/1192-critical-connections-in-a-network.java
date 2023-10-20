class Solution {
    
    int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        int [] discovery = new int[n];
        int [] low = new int[n];
        int [] parent = new int[n];
        
        Arrays.fill(discovery, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, connections);
        Set<List<Integer>> result = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            dfs(adjList, i, discovery, low, parent, result);
        }
        
        return new ArrayList<>(result);
    }

    private void dfs(Map<Integer, List<Integer>> adjList, int node, int [] discovery, int [] low,
                    int [] parent, Set<List<Integer>> result){
        
        low[node] = time;
        discovery[node] = time;
        
        time++;
        
        for(Integer neighbor: adjList.get(node)){
            
            if(discovery[neighbor] == -1){
                
               parent[neighbor] = node;
                
               dfs(adjList, neighbor, discovery, low, parent, result);
                
               low[node] = Math.min(low[node], low[neighbor]);
                
               if(low[neighbor] > discovery[node]){
                   result.add(Arrays.asList(Math.min(node, neighbor), Math.max(node, neighbor)));
               }
            
            } else if(neighbor != parent[node]){
                low[node] = Math.min(low[node], discovery[neighbor]);
            }
        }
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int n, List<List<Integer>> connections){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(List<Integer> connection: connections){
            int edge1 = connection.get(0);
            int edge2 = connection.get(1);
            adjList.get(edge1).add(edge2);
            adjList.get(edge2).add(edge1);
        }
        
        return adjList;
    }
}