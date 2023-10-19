class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, relations);
        
        Map<Integer, Integer> cache = new HashMap<>();
        
        int result = 0;
        
        for(int i = 1; i <= n; i++){
            result = Math.max(result, dfs(adjList, cache, time, i));
        }
        
        return result;
    }
    
    private int dfs(Map<Integer, List<Integer>> adjList, Map<Integer, Integer> cache,
                    int[] time, int node){
        
        if(cache.containsKey(node)){
            return cache.get(node);
        }
        
        int currTime = time[node - 1], res = 0;
        
        for(Integer neigh: adjList.get(node)){
            currTime = Math.max(currTime, dfs(adjList, cache, time, neigh) + time[node - 1]);
        }
        
        cache.put(node, currTime);
        
        return cache.get(node);
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int n, int[][] relations){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] relation: relations){
            int src = relation[0];
            int dest = relation[1];
            adjList.get(src).add(dest);
        }
        
        return adjList;
    }
}