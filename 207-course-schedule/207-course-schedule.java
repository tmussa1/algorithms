class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(prerequisites, numCourses);
        
        Set<Integer> explored = new HashSet<>();
        
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjList, explored, i, adjList.get(i))){
                return false;
            } 
        }
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int course,
                       List<Integer> lst){
        
        if(visited.contains(course)){
            return false;
        }
        
        if(lst == null || lst.size() == 0){
            return true;
        }
        
        visited.add(course);
        
        for(Integer element: lst){
            if(!dfs(adjList, visited, element, adjList.get(element))) {
                return false;
            }
        }
        
        visited.remove(course);
        adjList.put(course, new ArrayList<>());
        
        return true; 
    }
    
    private Map<Integer, List<Integer>> constructAdjList(int[][] prerequisites, int numCourses){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
            
        for(int i = 0; i < prerequisites.length; i++){
            if(adjList.containsKey(prerequisites[i][0])){
                adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> lst = new ArrayList<>();
                lst.add(prerequisites[i][1]);
                adjList.put(prerequisites[i][0], lst);
            }
        }
        
        return adjList;
    }
}