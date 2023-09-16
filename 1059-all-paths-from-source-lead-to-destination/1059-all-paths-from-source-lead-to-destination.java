class Solution {
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, edges);
        
        return dfs(adjList, source, destination, adjList.get(source), new HashMap<>(), n);
    }
    
    private boolean dfs(Map<Integer, List<Integer>> adjList, int node, int destination,
                        List<Integer> lst, Map<Integer, Boolean> seen, int n){
        
        if(seen.containsKey(node)){
            return seen.get(node);
        }
        
        if(lst.size() == 0){
            return node == destination;
        }
        
        seen.put(node, false);
        
        for(Integer neighbor: lst){
            
            if(!dfs(adjList, neighbor, destination, adjList.get(neighbor), seen, n)){
                return false;
            }
        }
        
        seen.put(node, true);
        
        return true;
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int n, int[][] edges){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
        }
        
        return adjList;
    }
}