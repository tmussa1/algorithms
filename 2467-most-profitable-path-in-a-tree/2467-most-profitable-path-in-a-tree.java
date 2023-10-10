class Solution {
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        
        Map<Integer, List<Integer>> adjList = buildAdjList(edges, indegreeMap);
        
        int [] time = new int[adjList.size()];
        int [] parent = new int[adjList.size()];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        Set<Integer> visited = new HashSet<>();
        
        int start = 0;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                
                int curr = queue.poll();
                visited.add(curr);

                time[curr] = start;

                for(Integer neighbor: adjList.get(curr)){
                    if(!visited.contains(neighbor)){
                        queue.offer(neighbor);
                        parent[neighbor] = curr;
                    }
                }
            }
            
            start++;
        }
        
        int curr = bob;
        
        start = 0;
        
        while(curr != 0){
            
            if(start == time[curr]){
                amount[curr] /= 2;
            } else if(start < time[curr]){
                amount[curr] = 0;
            }
                
            start++;
            curr = parent[curr];
        }
        
        Queue<int []> queue1 = new LinkedList<>();
        queue1.offer(new int [] {0, amount[0]});
        
        visited = new HashSet<>();
        
        int result = Integer.MIN_VALUE;
        
        while(!queue1.isEmpty()){
            
            int size = queue1.size();
            
            for(int i = 0; i < size; i++){
                
                int [] curr2 = queue1.poll();
                visited.add(curr2[0]);
                
                if(indegreeMap.get(curr2[0]) == 1 && curr2[0] != 0){
                    result = Math.max(result, curr2[1]);
                }

                for(Integer neighbor: adjList.get(curr2[0])){
                    if(!visited.contains(neighbor)){
                        queue1.offer(new int [] {neighbor, curr2[1] + amount[neighbor]});
                    }
                }
            }
        }
        
        return result;
    }
    
    Map<Integer, List<Integer>> buildAdjList(int[][] edges, Map<Integer, Integer> indegreeMap){
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int [] edge: edges){
            int edge1 = edge[0], edge2 = edge[1];
            List<Integer> lst1 = adjList.getOrDefault(edge1, new ArrayList<>());
            lst1.add(edge2);
            List<Integer> lst2 = adjList.getOrDefault(edge2, new ArrayList<>());
            lst2.add(edge1);
            adjList.put(edge1, lst1);
            adjList.put(edge2, lst2);
            indegreeMap.put(edge1, indegreeMap.getOrDefault(edge1, 0) + 1);
            indegreeMap.put(edge2, indegreeMap.getOrDefault(edge2, 0) + 1);
        }
        
        return adjList;
    }
}