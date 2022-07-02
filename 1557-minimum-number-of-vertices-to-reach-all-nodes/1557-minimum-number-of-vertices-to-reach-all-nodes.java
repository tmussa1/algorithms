class Solution {
    
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        Set<Integer> visited = new HashSet<>();
        
        Set<Integer> result = new HashSet<>();
        
        Map<Integer, List<Integer>> adjList = constructAdjList(edges);
        
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                result.add(i);
                dfs(adjList, adjList.get(i), visited, result, i);
            }
        }
    
        return new ArrayList<>(result);
    }
    
    void dfs(Map<Integer, List<Integer>> adjList, List<Integer> currList, Set<Integer> visited, Set<Integer> result, int i){
        
        if(visited.contains(i)){
            result.remove(i);
            return;
        }
        
        visited.add(i);
        
        if(currList != null && currList.size() > 0){
            for(Integer element: currList){
              dfs(adjList, adjList.get(element), visited, result, element);
            }
        }
    }
    
    Map<Integer, List<Integer>> constructAdjList(List<List<Integer>> edges){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < edges.size(); i++){
            List<Integer> lst = adjList.getOrDefault(edges.get(i).get(0), new ArrayList<>());
            lst.add(edges.get(i).get(1));
            adjList.put(edges.get(i).get(0), lst);
        }
        
        return adjList;
    }
}