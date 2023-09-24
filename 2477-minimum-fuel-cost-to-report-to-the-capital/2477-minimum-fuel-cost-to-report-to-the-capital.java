class Solution {
    
    long result = 0;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList(roads);
        
        dfs(adjList, 0, seats, new HashSet<>());
        
        return result;
    }
    
    private int dfs(Map<Integer, List<Integer>> adjList, int node,
                     int seats,
                     Set<Integer> visited){
        
        if(visited.contains(node)){
            return 0;
        }
        
        visited.add(node);
        
        int passengers = 0;
        
        if(adjList.get(node) != null) {
            for(Integer neighbor: adjList.get(node)){
                if(!visited.contains(neighbor)){
                   int passen = dfs(adjList, neighbor, seats, visited);
                   passengers += passen;
                   result += (passen / seats) + (passen % seats == 0 ? 0 : 1);
                }
            }
        }
        
        return passengers + 1;
    }
    
    Map<Integer, List<Integer>> buildAdjList(int[][] roads){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int [] road: roads){
            int source = road[0], dest = road[1];
            List<Integer> lst1 = adjList.getOrDefault(source, new ArrayList<>());
            lst1.add(dest);
            List<Integer> lst2 = adjList.getOrDefault(dest, new ArrayList<>());
            lst2.add(source);
            adjList.put(source, lst1);
            adjList.put(dest, lst2);
        }
        
        return adjList;
    }
}