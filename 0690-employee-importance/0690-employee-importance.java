/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Integer> importanceMap = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        buildAdjList(importanceMap, adjList, employees);
        
        return dfs(adjList, importanceMap, id, new HashSet<>());
    }
    
    private int dfs(Map<Integer, List<Integer>> adjList, 
                    Map<Integer, Integer> importanceMap,
                    int id, Set<Integer> visited){
        
        if(visited.contains(id)){
            return 0;
        }
        
        visited.add(id);
        
        int result = importanceMap.get(id);
        
        for(Integer neighbor: adjList.get(id)){
            if(!visited.contains(neighbor)){
                result += dfs(adjList, importanceMap, neighbor, visited);
            }
        }
        
        return result;
    }
    
    private void buildAdjList(Map<Integer, Integer> importanceMap,
                              Map<Integer, List<Integer>> adjList,
                              List<Employee> employees){
        
        for(Employee employee: employees){
            adjList.put(employee.id, employee.subordinates);
            importanceMap.put(employee.id, employee.importance);
        }
        
    }
}