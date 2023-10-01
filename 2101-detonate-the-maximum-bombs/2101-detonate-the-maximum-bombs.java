class Solution {
    
    public int maximumDetonation(int[][] bombs) {
        
        Map<Pair<Integer, Integer>, Integer> countMap = new HashMap<>();
        
        Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> adjList = buildAdjList(bombs, countMap);
        
        int result = 1;
        
        for(Pair<Integer, Integer> pair: adjList.keySet()){
            result = Math.max(result, dfs(pair, adjList, new HashSet<>(), countMap));
        }
        
        return result;
    }
    
    private int dfs(Pair<Integer, Integer> pair, Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> adjList, Set<Pair<Integer, Integer>> visited, Map<Pair<Integer, Integer>, Integer> countMap){
        
        if(visited.contains(pair)){
            return 0;
        }
        
        visited.add(pair);
        
        int result = countMap.get(pair);
        
        if(adjList.get(pair) != null) {
            for(Pair<Integer, Integer> neighbor: adjList.get(pair)){
                result += dfs(neighbor, adjList, visited, countMap);
            }
        }
            
        return result;
    }
    
    Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> buildAdjList(int[][] bombs,
                                        Map<Pair<Integer, Integer>, Integer> countMap){
        
        Map<Pair<Integer, Integer>, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        
        for(int i = 0; i < bombs.length; i++){
            
            int [] bomb1 = bombs[i];
            
            Pair<Integer, Integer> pair1 = new Pair<>(bomb1[0], bomb1[1]);
            
            countMap.put(pair1, countMap.getOrDefault(pair1, 0) + 1);
            
            long radius1 = ((long) Math.pow(bomb1[2], 2));
            
            for(int j = 0; j < bombs.length; j++){
                
                if(i == j){
                    continue;
                }
                
                int [] bomb2 = bombs[j];
                
                Pair<Integer, Integer> pair2 = new Pair<>(bomb2[0], bomb2[1]);
                
                if(areClose(bomb1, bomb2, radius1)){
                    List<Pair<Integer, Integer>> lst = adjList.getOrDefault(pair1, new ArrayList<>());
                    lst.add(pair2);
                    adjList.put(pair1, lst);
                }
            }
        }
        
        return adjList;
    }
    
    private boolean areClose(int [] bomb1,  int [] bomb2, long radius){
        long dist = ((long) (Math.pow(bomb1[0] - bomb2[0], 2) + Math.pow(bomb1[1] - bomb2[1], 2)));
        return dist <= radius;
    }
}