class Solution {
    
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        
        Map<Integer, List<Pair<Integer, Integer>>> adjList = constructAdjList(n, roads);
        
        long [] result = new long [n];
        
        Arrays.fill(result, Long.MAX_VALUE);
        
        for(int i = 1; i <= n; i++){
           bfs(adjList, i, appleCost, k, result, n);
        }
        
        return result;
    }
    
    private void bfs(Map<Integer, List<Pair<Integer, Integer>>> adjList, int node,
             int[] appleCost, int k, long [] result, int n){
        
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int [] {node, 0});
        
        long [] distance = new long [n];
        
        Arrays.fill(distance, Long.MAX_VALUE);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr = queue.poll();
                int key = curr[0] - 1;
                
                result[node - 1] = Math.min(result[node - 1], appleCost[key] + (k + 1) * curr[1]);
                
                for(Pair<Integer, Integer> neighbor: adjList.get(curr[0])){
                    
                    int dist = curr[1] + neighbor.getValue();
        
                    int key2 = neighbor.getKey() - 1;
                    
                    if(dist < distance[key2]){
                        distance[key2] = dist;
                        queue.offer(new int [] {neighbor.getKey(), dist});
                    }
                }
            }
            
        }
    }
    
    Map<Integer, List<Pair<Integer, Integer>>> constructAdjList(int n, int[][] roads){
        
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] road: roads){
            
            List<Pair<Integer, Integer>> lst1 = adjList.getOrDefault(road[0], new ArrayList<>());
            List<Pair<Integer, Integer>> lst2 = adjList.getOrDefault(road[1], new ArrayList<>());
            
            Pair<Integer, Integer> pair1 = new Pair<>(road[1], road[2]);
            Pair<Integer, Integer> pair2 = new Pair<>(road[0], road[2]);
            
            lst1.add(pair1);
            lst2.add(pair2);
            
            adjList.put(road[0], lst1);
            adjList.put(road[1], lst2);
        }
        
        return adjList;
    }
}