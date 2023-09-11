class Solution {
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, dislikes);
        Map<Integer, Integer> colorMap = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            if(!colorMap.containsKey(i)) {
                if(!bfs(adjList, i, colorMap)){
                  return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(Map<Integer, List<Integer>> adjList, int node,
                        Map<Integer, Integer> colorMap){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        colorMap.put(node, 1);
        
        while(!queue.isEmpty()){
                
            int curr = queue.poll();
            int currColor = colorMap.get(curr);

            for(Integer neighbor: adjList.get(curr)){
               if (!colorMap.containsKey(neighbor)) {
                    colorMap.put(neighbor, 3 - currColor);
                    queue.offer(neighbor);
               } else if (colorMap.get(neighbor) == currColor) {
                    return false;
               } 
            }
        }
        
        return true;
    }
    
    Map<Integer, List<Integer>> buildAdjList(int n, int[][] dislikes){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] dislike: dislikes){
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }
        
        return adjList;
    }
}