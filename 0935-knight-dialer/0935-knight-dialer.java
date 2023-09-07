class Solution {
    
        
    long MOD = 1_000_000_007;
    
    public int knightDialer(int n) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList();
        
        long result = 0;
        
        Map<String, Long> cacheMap = new HashMap<>();
        
        for(int i = 0; i <= 9; i++){
            long sum = knightDialer(n, i, 1, cacheMap, adjList);
            sum %= MOD;
            result = (result + sum) % MOD;
        }
        
        return (int) result;
    }
    
    public long knightDialer(int n, int node,
                            int count,
                            Map<String, Long> cacheMap,
                            Map<Integer, List<Integer>> adjList) {
        
        if(count == n){
            return 1;
        }
        
        String key = count + "," + node;
        
        if(cacheMap.containsKey(key)) return cacheMap.get(key);
        
        long result = 0;
        
        for(Integer neighbor: adjList.get(node)){
            count++;
            result %= MOD;
            result = (result + knightDialer(n, neighbor, count, cacheMap, adjList)) % MOD;
            count--;
        }
        
        cacheMap.put(key, result);
        
        return cacheMap.get(key);
    }
    
    private Map<Integer, List<Integer>> buildAdjList(){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        adjList.put(0, Arrays.asList(4, 6));
        adjList.put(1, Arrays.asList(6, 8));
        adjList.put(2, Arrays.asList(7, 9));
        adjList.put(3, Arrays.asList(4, 8));
        adjList.put(4, Arrays.asList(0, 3, 9));
        adjList.put(5, new ArrayList<>());
        adjList.put(6, Arrays.asList(0, 1, 7));
        adjList.put(7, Arrays.asList(2, 6));
        adjList.put(8, Arrays.asList(1, 3));
        adjList.put(9, Arrays.asList(2, 4));
        
        return adjList;
    }
}