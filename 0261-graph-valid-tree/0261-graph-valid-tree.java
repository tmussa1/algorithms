class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(n, edges);

        boolean visited [] = new boolean[n];
        Arrays.fill(visited, false);

        dfs(adjList, visited, 0);
        
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                return false;
            }
        }
        
        Arrays.fill(visited, false);
        
        for(Integer row: adjList.keySet()){
            if(!visited[row]){
                if(containsCycle(adjList, visited, row, row)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    void dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int v){
         
        visited[v] = true;
        List<Integer> adjEdges = adjList.get(v);
        
        if(adjEdges != null && adjEdges.size() != 0){
            for(Integer row: adjEdges){
                if(!visited[row]){
                    dfs(adjList, visited, row);
                }
            }
        }
       
    }
    
    boolean containsCycle(Map<Integer, List<Integer>> adjList, boolean[] visited, int v, int parent){
        
        visited[v] = true;
            
        List<Integer> adjEdges = adjList.get(v);
        
        for(int j = 0; j < adjEdges.size(); j++){
            if(!visited[adjEdges.get(j)]){
                if(containsCycle(adjList, visited, adjEdges.get(j), v)) {
                    return true;
                }
            } else if(adjEdges.get(j) != parent){
                return true;
            }
        }
        
        return false;
    }
    
    Map<Integer, List<Integer>> constructAdjList(int n, int[][] edges){
        
        Map<Integer, List<Integer>> result = new HashMap<>();
        
        for(int row = 0; row < edges.length; row++){
            List<Integer> lst = result.getOrDefault(edges[row][0], new ArrayList<>());
            lst.add(edges[row][1]);
            result.put(edges[row][0], lst);
            List<Integer> lst2 = result.getOrDefault(edges[row][1], new ArrayList<>());
            lst2.add(edges[row][0]);
            result.put(edges[row][1], lst2);
        }
        
        return result;
    }

}