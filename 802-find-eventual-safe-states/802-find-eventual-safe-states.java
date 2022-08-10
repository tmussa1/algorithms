class Solution {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<Integer> result = new ArrayList<>();
        
        Set<Integer> seen = new HashSet<>();
        
        for(int i = 0; i < graph.length; i++){
            if(dfs(graph, i, new int [graph.length], new int [graph.length])){
                result.add(i);
            }
        }
            
        Collections.sort(result);
        
        return result;
    }
    
    boolean dfs(int [] [] graph,
               int node, int [] seen, int [] cycle){
        
        if(cycle[node] == 1){
            return false;
        }
        
        if(seen[node] == 1 || graph[node].length == 0){
            return true;
        }
        
        cycle[node] = 1;
        seen[node] = 1;
        
        for(int element: graph[node]){
            if(!dfs(graph, element, seen, cycle)){
                return false;
            }
        }
        
        cycle[node] = 0;
        
        return true;
    }
}