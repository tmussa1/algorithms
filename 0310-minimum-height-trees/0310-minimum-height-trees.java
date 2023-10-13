class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        Set<Integer> result = new HashSet<>();
        
        if(edges.length == 0) return Arrays.asList(0);
        
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> adjList = constructAdjList(edges, indegreeMap);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(Integer key: indegreeMap.keySet()){
            if(indegreeMap.get(key) == 1){
                queue.offer(key);
            }
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            result = new HashSet<>();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                visited.add(curr);
                result.add(curr);
                
                for(Integer neighbor: adjList.get(curr)){
                    if(!visited.contains(neighbor)){
                        indegreeMap.put(neighbor, indegreeMap.getOrDefault(neighbor, 0) - 1);
                        if(indegreeMap.get(neighbor) == 1){
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<>(result);
    }
    
    Map<Integer, List<Integer>> constructAdjList(int[][] edges, Map<Integer, Integer> indegreeMap){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < edges.length; i++){
            int edge1 = edges[i][0], edge2 = edges[i][1];
            List<Integer> lst1 = adjList.getOrDefault(edge1, new ArrayList<>());
            List<Integer> lst2 = adjList.getOrDefault(edge2, new ArrayList<>());
            lst1.add(edge2);
            lst2.add(edge1);
            adjList.put(edge1, lst1);
            adjList.put(edge2, lst2);
            indegreeMap.put(edge1, indegreeMap.getOrDefault(edge1, 0) + 1);
            indegreeMap.put(edge2, indegreeMap.getOrDefault(edge2, 0) + 1);
        }
        
        return adjList;
    }
}