class Solution {
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int length = edges.length;
        
        Map<Integer, List<Integer>> adjList = buildAdjList(edges);
        
        int [] time1 = new int[length];
        
        Arrays.fill(time1, -1);
        
        int [] time2 = new int[length];
        
        Arrays.fill(time2, -1);
        
        populateTime(node1, time1, adjList);
        populateTime(node2, time2, adjList);
        
        for(int i = 0; i < edges.length; i++){
            if(time1[i] == -1 || time2[i] == -1){
               time1[i] = -1;
            } else {
               time1[i] = Math.max(time1[i], time2[i]);
            }
        }
        
        int min = Integer.MAX_VALUE, index = -1;
        
        for(int i = 0; i < edges.length; i++){
           if(time1[i] != -1 && time1[i] < min){
               min = time1[i];
               index = i;
           }
        }
        
        return index;
    }
    
    private void populateTime(int node, int [] time, Map<Integer, List<Integer>> adjList){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        Set<Integer> visited = new HashSet<>();
        
        int distance = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                time[curr] = distance;
                visited.add(curr);
                
                for(int neighbor: adjList.get(curr)){
                    if(!visited.contains(neighbor)){
                        queue.offer(neighbor);
                    }
                }
            }
            
            distance++;
        }
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int[] edges){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
           int start = i;
           int end = edges[i];
           if(end == -1) continue;
           adjList.get(start).add(end);
        }
        
        return adjList;
    }
}