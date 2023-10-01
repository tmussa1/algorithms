class Solution {
    
    
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<Pair<Integer, Integer>>> adjList = buildAdjList(n, roads);
        
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
         
        Pair<Integer, Integer> pair = new Pair<>(1, Integer.MAX_VALUE);
        
        queue.offer(pair);
        
        int result = Integer.MAX_VALUE;
        
        Set<Integer> visited = new HashSet<>();
        
        int [] distance = new int[n + 1];
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                Pair<Integer, Integer> curr = queue.poll();
                
                distance[curr.getKey()] = curr.getValue();
                
                visited.add(curr.getKey());
                
                if(curr.getKey() == n){
                    result = Math.min(result, curr.getValue());
                }
                
                List<Pair<Integer, Integer>> lst = adjList.get(curr.getKey());
                
                for(Pair<Integer, Integer> pair1: lst){
                    
                    int dist = Math.min(curr.getValue(), pair1.getValue());
                        
                    if(!visited.contains(pair1.getKey()) || dist < distance[pair1.getKey()]){
                        queue.offer(new Pair<>(pair1.getKey(), dist));
                    }
                }
            }
        }
        
        return result;
    }
    
    private Map<Integer, List<Pair<Integer, Integer>>> buildAdjList(int n, int[][] roads){
        
        Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] edge: roads){
            int edge1 = edge[0];
            int edge2 = edge[1];
            Pair<Integer, Integer> pair1 = new Pair<>(edge2, edge[2]);
            Pair<Integer, Integer> pair2 = new Pair<>(edge1, edge[2]);
            adjList.get(edge1).add(pair1);
            adjList.get(edge2).add(pair2);
        }
        
        return adjList;
    }
}