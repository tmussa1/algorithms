class Solution {
    
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        
        Map<Integer, List<Integer>> adjList = buildAdjList(numCourses, prerequisites);
        
        for(int [] query: queries){
            result.add(dfs(adjList, query[0], query[1], new HashSet<>()));
        }
        
        return result;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> adjList,
                        int start, int end, Set<Integer> visited){
        
        if(start == end) {
            return true;
        }
        
        if(visited.contains(start)){
            return false;
        }
        
        visited.add(start);
        
        for(Integer neighbor: adjList.get(start)){
            if(dfs(adjList, neighbor, end, visited)){
                return true;
            }
        }
        
        return false;
    }
    
    Map<Integer, List<Integer>> buildAdjList(int numCourses, int[][] prerequisites){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] prereq: prerequisites){
            adjList.get(prereq[0]).add(prereq[1]);
        }
        
        return adjList;
    }
}