class Solution {
    
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int [] result = new int[n];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        int level = 0;
        
        Map<Integer, List<Integer>> adjListRed = new HashMap<>();
        Map<Integer, List<Integer>> adjListBlue = new HashMap<>();
        
        buildAdjList(n, redEdges, blueEdges, adjListRed, adjListBlue);
        
        Set<Integer> visitedRed = new HashSet<>();
        Set<Integer> visitedBlue = new HashSet<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                result[curr] = Math.min(level, result[curr]);
                
                if(level % 2 == 0){
                    List<Integer> neighbors = adjListRed.get(curr);
                    for(Integer neighbor: neighbors){
                        if(!visitedRed.contains(neighbor)) {
                            queue.add(neighbor);
                            visitedRed.add(neighbor);
                        }
                    }
                } else {
                    List<Integer> neighbors = adjListBlue.get(curr);
                    for(Integer neighbor: neighbors){
                        if(!visitedBlue.contains(neighbor)) {
                            queue.add(neighbor);
                            visitedBlue.add(neighbor);
                        }
                    }
                }
            }
            
            level++;
        }
        
        queue = new LinkedList<>();
        queue.offer(0);
        
        level = 0;
        
        visitedRed = new HashSet<>();
        visitedBlue = new HashSet<>();
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                result[curr] = Math.min(level, result[curr]);
                
                if(level % 2 == 0){
                    List<Integer> neighbors = adjListBlue.get(curr);
                    for(Integer neighbor: neighbors){
                        if(!visitedBlue.contains(neighbor)) {
                            queue.add(neighbor);
                            visitedBlue.add(neighbor);
                        }
                    }
                } else {
                    List<Integer> neighbors = adjListRed.get(curr);
                    for(Integer neighbor: neighbors){
                        if(!visitedRed.contains(neighbor)) {
                            queue.add(neighbor);
                            visitedRed.add(neighbor);
                        }
                    }
                }
            }
            
            level++;
        }
        
        for(int i = 0; i < n; i++){
            if(result[i] == Integer.MAX_VALUE){
               result[i] = -1;
            }
        }
        
        return result;
    }
    
    
    void buildAdjList(int n, int[][] redEdges, int[][] blueEdges,
                                            Map<Integer, List<Integer>> adjListRed,
                                            Map<Integer, List<Integer>> adjListBlue){
        
        for(int i = 0; i < n; i++){
            adjListRed.put(i, new ArrayList<>());
            adjListBlue.put(i, new ArrayList<>());
        }
        
        for(int [] redEdge: redEdges){
            adjListRed.get(redEdge[0]).add(redEdge[1]);
        }
        
        for(int [] blueEdge: blueEdges){
            adjListBlue.get(blueEdge[0]).add(blueEdge[1]);
        }
    }
}