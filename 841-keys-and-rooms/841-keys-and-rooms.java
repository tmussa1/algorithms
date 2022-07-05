class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(rooms);
        Set<Integer> visited = new HashSet<>();
        
        dfs(adjList, 0, visited, adjList.get(0));
        
        return visited.size() == rooms.size();
    }
    
    private void dfs(Map<Integer, List<Integer>> adjList, int node, 
                     Set<Integer> visited,
                     List<Integer> currList){
        
        if(visited.contains(node)){
            return;
        }
        
        visited.add(node);
        
        if(currList != null && currList.size() > 0){
            for(Integer element: currList){
                dfs(adjList, element, visited, adjList.get(element));
            }
        }
    }
    
    
    private Map<Integer, List<Integer>> constructAdjList(List<List<Integer>> rooms){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < rooms.size(); i++){
            int curr = i;
            List<Integer> lst = adjList.getOrDefault(curr, new ArrayList<>());  
            for(int j = 0; j < rooms.get(i).size(); j++){
                lst.add(rooms.get(i).get(j));
            }
            adjList.put(curr, lst);
        }
        
        return adjList;
    }
}