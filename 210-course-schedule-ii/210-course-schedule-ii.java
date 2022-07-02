class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = constructAdjacencyList(prerequisites);
        
//         for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()){
            
//             System.out.print(entry.getKey() + " ");
            
//             for(Integer val : entry.getValue()){
//                 System.out.print(val + " ");
//             }
            
//             System.out.println();
//         }
        
        LinkedList<Integer> result = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjList, adjList.get(i), result, i, visited, new HashSet<>())) {
                return new int [] {};
            }
        }
        
        return result.stream().mapToInt(a -> a).toArray();
    }
    
    boolean dfs(Map<Integer, List<Integer>> adjList, List<Integer> currList, 
             LinkedList<Integer> result, int course, Set<Integer> visited, Set<Integer> cycle){
        
        if(cycle.contains(course)){
            return false;
        }
        
        if(visited.contains(course)){
            return true;
        }
        
        visited.add(course);
        
        cycle.add(course);
        
        if(currList != null && currList.size() > 0){
            for(Integer element: currList){
                if(!dfs(adjList, adjList.get(element), result, element, visited, cycle)) {
                    return false;
                }
            }
        }
        
        result.add(course);
        cycle.remove(course);
        // visited.remove(course);
        // adjList.put(course, new ArrayList<>());
        
        
        return true;
    }


    Map<Integer, List<Integer>> constructAdjacencyList(int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            
            List<Integer> lst = adjList.getOrDefault(key, new ArrayList<>());
            lst.add(value);
            
            adjList.put(key, lst);
        }
        
        return adjList;
    }
}