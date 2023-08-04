class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Integer> indegree = new HashMap<>();
        
        Map<Integer, List<Integer>> adjList = buildAdjList(numCourses, prerequisites,
                                                           indegree);
        
        Queue<Integer> queue = new LinkedList<>();
        
        int takenCourses = 0;
        
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()){
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }
       
        
        if(queue.size() == 0) return false;
        
        while(!queue.isEmpty()){
            
            int curr = queue.poll();
            
            takenCourses++;
            
            List<Integer> neighbors = adjList.get(curr);
            
            for(Integer neighbor: neighbors){
               indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) - 1);
               if(indegree.get(neighbor) == 0){
                   queue.offer(neighbor);
               }
            }
        }
        
        return takenCourses == numCourses;
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int numCourses, 
                                                     int[][] prerequisites,
                                                     Map<Integer, Integer> indegree){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
            indegree.put(i, 0);
        }
        
        for(int [] prereq: prerequisites){
            int course = prereq[1], prereqCourse = prereq[0];
            List<Integer> lst = adjList.get(course);
            lst.add(prereqCourse);
            adjList.put(course, lst);
            incrementInDegree(indegree, prereqCourse);
        }
        
        return adjList;
    }
    
    private void incrementInDegree(Map<Integer, Integer> indegree, int destination){
        indegree.put(destination, indegree.getOrDefault(destination, 0) + 1);
    }
}