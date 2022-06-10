class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
          
        if(source == destination){
            return true;
        }
        
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            
            Set<Integer> lst1 = adjList.getOrDefault(edges[i][0], new HashSet<>());
            lst1.add(edges[i][1]);
            adjList.put(edges[i][0], lst1);
            
            Set<Integer> lst2 = adjList.getOrDefault(edges[i][1], new HashSet<>());
            lst2.add(edges[i][0]);
            adjList.put(edges[i][1], lst2);
        }
        
        Set<Integer> visited = new HashSet<>();
            
        return dfs(adjList, adjList.get(source), source, destination, visited);
    }
    
    private boolean dfs(Map<Integer, Set<Integer>> adjList, Set<Integer> lst, int source, int destination, Set<Integer> visited){
        
        if(lst == null || lst.size() == 0 || visited.contains(source)){
            return false;
        }
        
        if(lst.contains(destination)){
            return true;
        }
        
        visited.add(source);
        
        Set<Integer> adjacent = adjList.get(source);
            
        for(Integer key: adjacent){
            if(dfs(adjList, adjList.get(key), key, destination, visited)) {
                return true;
            }
        }
        
        return false;
    }
}