class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, List<Integer>> adjList = constructAdjList(manager);
        List<Integer> initial = adjList.get(headID);
        int [] sum = new int[1];
        
        dfs(adjList, initial, manager, informTime, sum, 0, headID);
        
        return sum[0];
    }
    
    private void dfs(Map<Integer, List<Integer>> adjList, List<Integer> lst, int[] manager, int[] informTime, int [] result, int currSum, int node){
        
        result[0] = Math.max(currSum, result[0]);
        
        if(adjList.containsKey(node) && adjList.get(node).size() > 0){
            for(Integer element: adjList.get(node)){
                dfs(adjList, adjList.get(element), manager, informTime, result, currSum + informTime[node], element);
            }
        }
    }
    
    private Map<Integer, List<Integer>> constructAdjList(int [] manager){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
            
        for(int i = 0; i < manager.length; i++){      
            int empManager = manager[i];
            if(empManager != -1){
                List<Integer> lst = adjList.getOrDefault(empManager, new ArrayList<>());
                lst.add(i);
                adjList.put(empManager, lst); 
            }
        }
        
        return adjList; 
    }
}