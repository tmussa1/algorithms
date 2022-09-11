class Solution {
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(pid, ppid);
        
        List<Integer> result = new ArrayList<>();
        
        findChildProcesses(adjList, kill, result, new HashSet<Integer>());
        
        return result;
    }
    
    private void findChildProcesses(Map<Integer, List<Integer>> adjList, int node, List<Integer> result,
                                    Set<Integer> visited){
        
        if(visited.contains(node)){
            return;
        }
        
        visited.add(node);
        result.add(node);
        
        for(Integer neighbor: adjList.get(node)){
            findChildProcesses(adjList, neighbor, result, visited);
        }
    }
    
    private Map<Integer, List<Integer>> constructAdjList(List<Integer> pid, List<Integer> ppid){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int index = 0; index < pid.size(); index++){
            int childId = pid.get(index);
            adjList.put(childId, new ArrayList<>());
        }
        
        for(int index = 0; index < ppid.size(); index++){
            
            int parentId = ppid.get(index), childId = pid.get(index);
            
            List<Integer> childList = adjList.getOrDefault(parentId, new ArrayList<>());
            childList.add(childId);
            
            adjList.put(parentId, childList);
        }
        
        return adjList;
    }
}