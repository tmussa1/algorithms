class Solution {
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int [] [] countArray = new int [n] [26];
        
        Map<Integer, Character> charMap = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            countArray[i][labels.charAt(i) - 'a']++;
            charMap.put(i, labels.charAt(i));
        }
        
        Map<Integer, List<Integer>> adjList = buildAdjList(n, edges);
        
        dfs(0, charMap, countArray, adjList, new HashSet<>());
        
        int [] result = new int [n];
        
        for(int i = 0; i < countArray.length; i++){
            result[i] = countArray[i][charMap.get(i) - 'a'];
        }
        
        return result;
    }
    
    private void dfs(int node, Map<Integer, Character> charMap, int [] [] countArray,
                    Map<Integer, List<Integer>> adjList, Set<Integer> visited){
        
        if(visited.contains(node)){
            return;
        }
        
        visited.add(node);
        
        for(Integer neighbor: adjList.get(node)){
            
            if(!visited.contains(neighbor)){
             
                dfs(neighbor, charMap, countArray, adjList, visited);

                for(int i = 0; i < 26; i++){
                     countArray[node][i] += countArray[neighbor][i];
                }
            }
        }
    }
    
    private Map<Integer, List<Integer>> buildAdjList(int n, int[][] edges){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }
        
        for(int [] edge: edges){
            int edge1 = edge[0], edge2 = edge[1];
            adjList.get(edge1).add(edge2);
            adjList.get(edge2).add(edge1);
        }
        
        return adjList;
    }
}