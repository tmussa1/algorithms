class Solution {
    
    Map<Integer, Integer> indegreeMap = new HashMap<>();
    
    public int minimumSemesters(int n, int[][] relations) {
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, relations);
        
        int level = 0;
        
        for(Integer key: indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0){
                queue.offer(key);
            }
        }
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                
                if(visited.contains(curr)) return -1;
                
                visited.add(curr);
                
                for(Integer neighbor: adjList.get(curr)){
                    indegreeMap.put(neighbor, indegreeMap.get(neighbor) - 1);
                    if(indegreeMap.get(neighbor) == 0){
                        queue.offer(neighbor);
                    }
                }
            }
            
            level++;
        }
        
        return visited.size() != n ? -1 : level;
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int n, int[][] relations){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 1; i <= n; i++){
            adjList.put(i, new ArrayList<>());
            indegreeMap.put(i, 0);
        }
        
        for(int [] relation: relations){
            int course = relation[0];
            int prereq = relation[1];
            List<Integer> lst = adjList.get(course);
            lst.add(prereq);
            adjList.put(course, lst);
            indegreeMap.put(prereq, indegreeMap.getOrDefault(prereq, 0) + 1);
        }
        
        return adjList;
    }
}